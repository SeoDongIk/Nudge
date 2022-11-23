package com.example.nudge.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nudge.Dao.SquadDao
import com.example.nudge.Dao.StashDao
import com.example.nudge.Dao.UserDao
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.StashEntity
import com.example.nudge.Entity.UserEntity

@Database(entities = [UserEntity::class, SquadEntity::class, StashEntity::class], version = 2)
abstract class SquadDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao
    abstract fun squadDao() : SquadDao
    abstract fun stashDao() : StashDao

    companion object {
        @Volatile
        private var INSTANCE : SquadDatabase? = null

        fun getDatabase(
            context : Context
        ) : SquadDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SquadDatabase::class.java,
                    "squad_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}