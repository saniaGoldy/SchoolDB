package com.example.schooldb.data.localDB.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director(
    @PrimaryKey(autoGenerate = false)
    val login: String,
    val password: String,
    val name: String
)
