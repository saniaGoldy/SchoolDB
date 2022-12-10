package com.example.schooldb.data.localDB.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SchoolClass(
    @PrimaryKey
    @ColumnInfo(name = "school_class_id") val schoolClassId: Int,
    val name: String,
    val students: String
)