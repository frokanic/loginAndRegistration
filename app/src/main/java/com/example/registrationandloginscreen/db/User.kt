package com.example.registrationandloginscreen.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users_table", indices = [Index(value = ["username","email"], unique = true)])
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var firstName: String,
    var lastName: String,
    var username: String,
    var email: String,
    var password: String
)