package com.example.nudge.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class PlayerEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "name")
    var name : String = "",
    @ColumnInfo(name = "imageUrl")
    var imageUrl : String = ""
)