package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "director_login") val directorLogin: String,
    val password: String,
    val name: String
)
