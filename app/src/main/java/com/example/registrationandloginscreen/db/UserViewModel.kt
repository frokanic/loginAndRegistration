package com.example.registrationandloginscreen.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<User>>
    private val repository: UsersRepository

    init {
        val usersDao = UsersDatabase.getDatabase(application).usersDao()
        repository = UsersRepository(usersDao)
        readAllData = repository.readAllData
    }

    fun addUser(
        user: User,
        /*toString: String,
        toString1: String,
        toString2: String,
        toString3: String*/
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}