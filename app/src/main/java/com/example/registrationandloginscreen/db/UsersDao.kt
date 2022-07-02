package com.example.registrationandloginscreen.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(user: User)

    @Query("Select * from users_table Order By id desc")
    fun readAllData(): LiveData<List<User>>

    @Query("Select * from users_table Where username = :username")
    fun readUsernnames(username: String): LiveData<List<User>>

    /*
    @Query("Select username from users_table Where username = :username")
    fun readUsernnamesUsername(username: String): String?

    @Query("Select * from users_table Where email = :email")
    fun readEmails(email: String): User?

    @Query("Select * from users_table Where password = :password")
    fun readPasswords(password: String): User? */

}