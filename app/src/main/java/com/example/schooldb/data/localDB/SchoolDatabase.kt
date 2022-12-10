package com.example.schooldb.data.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.schooldb.data.localDB.entities.Director

@Database(entities = [Director::class], version = 2)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object {
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                SchoolDatabase::class.java,
                SCHOOL_DATABASE_NAME
            ).build().also {
                INSTANCE = it
            }
        }
    }
}