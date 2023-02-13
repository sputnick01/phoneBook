package com.example.roomdb.repository

import androidx.lifecycle.LiveData
import com.example.roomdb.data.UserDao
import com.example.roomdb.model.UserEntity

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<UserEntity>> = userDao.getAllData()

    suspend fun addUser(user: UserEntity) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }
}

