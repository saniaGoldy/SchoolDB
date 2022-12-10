package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Journal(
    @PrimaryKey
    @ColumnInfo(name = "journal_id")val journalId: Int,
    @ColumnInfo(name = "lesson_id") val lessonID: Int,
    @ColumnInfo(name = "student_login") val studentLogin: String,
    val mark: String
)