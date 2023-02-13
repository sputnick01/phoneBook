package com.example.roomdb.update

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.R
import com.example.roomdb.model.UserEntity
import com.example.roomdb.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_update.*

class Update : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        receivedData()
        menu()
        button_update.setOnClickListener {

            updateUser()

        }



    }

    private fun menu() {
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.delete_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                if (menuItem.itemId == R.id.icon_delete) {
                    var deleteUser = UserEntity(id, "", "", "","")
                    userViewModel = ViewModelProvider(this@Update).get(UserViewModel::class.java)
                    userViewModel.deleteUser(deleteUser)
                    Toast.makeText(this@Update, "Delete User Successfully !!", Toast.LENGTH_LONG)
                        .show()
                    finish()
                }
                return true
            }
        })

    }


    private fun updateUser() {
//        Create updateUser
        val updateUser = UserEntity(
            id,
            edittext_updateName.text.toString(),
            edittext_updatelastName.text.toString(),
            edittext_updateEmail.text.toString(),
            edittext_updatePhone.text.toString()
        )
//        Create userViewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
//       updateUser
        userViewModel.updateUser(updateUser)
    }

    private fun receivedData() {
        val b = intent.extras
        id = b?.getInt("id") ?: 1
        var name = b?.getString("name") ?: ""
        var lastname = b?.getString("lastname") ?: ""
        var email = b?.getString("email") ?: ""
        var phone = b?.getString("phone") ?: ""
        edittext_updateName.setText(name)
        edittext_updatelastName.setText(lastname)
        edittext_updateEmail.setText(email)
        edittext_updatePhone.setText(phone)

    }

}