package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson(
    @PrimaryKey
    @ColumnInfo(name = "lesson_id") val lessonId: Int,
    val auditorium: String,
    @ColumnInfo(name = "school_class_id") val schoolClassId: Int,
    @ColumnInfo(name = "teacher_login") val teacherLogin: String,
    @ColumnInfo(name = "lesson_time") val lessonTime: String,
    @ColumnInfo(name = "discipline_id") val disciplineId: Int,
)