package com.example.schooldb.data.localDB.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.schooldb.data.localDB.entities.Journal
import com.example.schooldb.data.localDB.entities.Student

data class StudentWithJournalEntries(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "student_login",
        entityColumn = "student_login"
    )
    val journal: List<Journal>
)