package com.example.schooldb.data.localDB.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.schooldb.data.localDB.entities.Journal
import com.example.schooldb.data.localDB.entities.Lesson

data class JournalAndLesson(
    @Embedded val journal: Journal,
    @Relation(
        parentColumn = "lesson_id",
        entityColumn = "lesson_id"
    )
    val lesson: Lesson
)
