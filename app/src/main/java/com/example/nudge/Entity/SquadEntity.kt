package com.example.nudge.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "squad_table")
data class SquadEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "formation")
    var formation : Int,
    @ColumnInfo(name = "position")
    var position : Int,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name = "key")
    var key : String
)