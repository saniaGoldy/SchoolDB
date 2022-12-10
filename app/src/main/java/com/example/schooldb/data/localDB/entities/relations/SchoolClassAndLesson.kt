package com.example.schooldb.data.localDB.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.schooldb.data.localDB.entities.Lesson
import com.example.schooldb.data.localDB.entities.SchoolClass

data class SchoolClassAndLesson(
    @Embedded val schoolClass: SchoolClass,
    @Relation(
        parentColumn = "school_class_id",
        entityColumn = "school_class_id"
    )
    val lesson: Lesson
)