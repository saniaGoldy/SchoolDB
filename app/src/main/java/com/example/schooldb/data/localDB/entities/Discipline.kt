package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Discipline(
    @PrimaryKey
    @ColumnInfo(name = "discipline_id") val disciplineId: Int,
    val name: String,
    val teachers: String
)