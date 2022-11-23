package com.example.nudge.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stash_table")
data class StashEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "position")
    var position : Int,
    @ColumnInfo(name = "formation")
    var formation : Int,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name = "key")
    var key : String
)