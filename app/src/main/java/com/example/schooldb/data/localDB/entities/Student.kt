package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "student_login") val studentLogin: String,
    val password:String,
    val name: String
)
