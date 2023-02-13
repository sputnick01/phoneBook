package com.example.roomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.UserDatabase
import com.example.roomdb.model.UserEntity
import com.example.roomdb.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<UserEntity>>
    private var userRepository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
        getAllData = userRepository.readAllData
    }

    fun addUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)

        }


    }

    fun updateUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)

        }


    }

    fun deleteUser(user: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)

        }


    }

}