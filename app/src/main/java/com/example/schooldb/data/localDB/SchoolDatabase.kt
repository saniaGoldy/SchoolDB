package com.example.schooldb.data.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.schooldb.data.localDB.entities.*

@Database(
    entities = [
        Director::class,
        Discipline::class,
        Teacher::class,
        Student::class,
        Journal::class,
        Lesson::class,
        SchoolClass::class
               ],
    version = 4
)
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