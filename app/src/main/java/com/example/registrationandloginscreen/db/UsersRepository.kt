package com.example.registrationandloginscreen.db

import androidx.lifecycle.LiveData

class UsersRepository(private val usersDao: UsersDao) {

    val readAllData = usersDao
    val readSomeData = listOf(usersDao.toString())

    val readData = usersDao.readAllData()

    fun addUser(user: User){
        usersDao.insertUser(user)
    }

    fun userExists(user: String): LiveData<List<User>> {
        return usersDao.readUsernnames(user)
    }
}

