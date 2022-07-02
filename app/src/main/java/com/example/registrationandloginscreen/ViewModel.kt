package com.example.registrationandloginscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.registrationandloginscreen.db.User
import com.example.registrationandloginscreen.db.UsersDatabase
import com.example.registrationandloginscreen.db.UsersRepository

class MyViewModel(application: Application) : AndroidViewModel(application) {

    val data: LiveData<List<User>>
    val repository: UsersRepository
        get() {
            TODO()
        }

    init {
        val dao = UsersDatabase.getDatabase(application).usersDao()
        val repository = UsersRepository(dao)
        data = repository.readData
    }

    fun addUser(user: User) = repository.addUser(user)


    fun userExists(user: String): LiveData<List<User>> = repository.userExists(user)
}