package com.example.nudge.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nudge.Entity.PlayerEntity

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player_table")
    fun getAllData(): List<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(squad : PlayerEntity)

    @Query("DELETE FROM player_table")
    fun deleteAllData()
}