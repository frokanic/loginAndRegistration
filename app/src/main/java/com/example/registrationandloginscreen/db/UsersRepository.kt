package com.example.registrationandloginscreen.db

import androidx.lifecycle.LiveData
import android.util.Log

class UsersRepository(private val usersDao: UsersDao) {

    val readAllData = usersDao
    val readSomeData = listOf(usersDao.toString())

    val readData = usersDao.readAllData()

    fun addUser(user: User){
        usersDao.insertUser(user)
    }
/*
    fun getUsername(username: String): User? {
        return readAllData.readUsernnames(username)
    }

    fun getUsername(username: String): User? {
        return readAllData.readUsernnames(username)
    } */
}

//user.username