package com.example.roomdb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdb.adapter.ListAdapter
import com.example.roomdb.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initialRecyclerView()


        fab.setOnClickListener {

            val intent = Intent(this, Main::class.java)
            startActivity(intent)
        }

    }

    private fun initialRecyclerView() {
        val adapter = ListAdapter(this)
        val recyclerView = recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getAllData.observe(this, Observer { user ->

            adapter.setData(user)

        })


    }
}