package com.example.nudge.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nudge.Entity.StashEntity

@Dao
interface StashDao {
    @Query("SELECT * FROM stash_table")
    fun getAllData(): List<StashEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(stash : StashEntity)

    @Query("DELETE FROM stash_table")
    fun deleteAllData()
}