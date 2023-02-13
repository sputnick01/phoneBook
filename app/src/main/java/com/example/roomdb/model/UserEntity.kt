package com.example.roomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "firstname") var name: String,
    @ColumnInfo(name = "lastname") var lastname: String,
    @ColumnInfo(name = "email") var email: String, @ColumnInfo(name = "phone") var phone: String
)
