package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "teacher_login") val teacherLogin: String,
    val password:String,
    val name: String
)
