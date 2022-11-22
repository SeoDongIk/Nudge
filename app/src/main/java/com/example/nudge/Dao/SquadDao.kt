package com.example.nudge.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nudge.Entity.SquadEntity

@Dao
interface SquadDao {
    @Query("SELECT * FROM squad_table")
    fun getAllData(): List<SquadEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(squad : SquadEntity)

    @Query("DELETE FROM squad_table")
    fun deleteAllData()
}