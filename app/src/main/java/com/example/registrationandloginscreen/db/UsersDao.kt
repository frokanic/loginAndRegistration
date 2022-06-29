package com.example.registrationandloginscreen.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Query("Select * from users_table Order By id asc")
    fun readAllData(): LiveData<List<User>>



}