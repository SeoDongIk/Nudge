package com.example.nudge.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nudge.Entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    fun getAllData(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user : UserEntity)

    @Query("DELETE FROM user_table")
    fun deleteAllData()
}