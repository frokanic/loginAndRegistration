package com.example.registrationandloginscreen.db

import androidx.lifecycle.LiveData

class UsersRepository(private val usersDao: UsersDao) {

    val readAllData: LiveData<List<User>> = usersDao.readAllData()

    fun addUser(user: User){
        usersDao.insertUser(user)
    }

}