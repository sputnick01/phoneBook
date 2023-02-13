package com.example.roomdb

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.model.UserEntity
import com.example.roomdb.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class Main : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_Register.setOnClickListener {

//            Add user to database
            addData()
//            Delete data from edittext after saving
            clearEditText()

        }
    }

    private fun addData() {

        var firstName = edittext_Name.text.toString()
        var lastName = edittext_lastName.text.toString()
        var email = edittext_Email.text.toString()
        var phone = edittext_phone.text.toString()

        val user = UserEntity(0, firstName, lastName, email, phone)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.addUser(user)
        Toast.makeText(this, "Successfully Added!", Toast.LENGTH_LONG).show()


    }

    private fun clearEditText() {
        edittext_Name.text?.clear()
        edittext_lastName.text?.clear()
        edittext_Email.text?.clear()
        edittext_phone.text?.clear()

    }
}