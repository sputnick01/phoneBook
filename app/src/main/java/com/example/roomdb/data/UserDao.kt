package com.example.roomdb.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdb.model.UserEntity

@Dao
interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)


    @Query("SELECT * FROM USER_TABLE ORDER BY id ASC ")
    fun getAllData(): LiveData<List<UserEntity>>

}