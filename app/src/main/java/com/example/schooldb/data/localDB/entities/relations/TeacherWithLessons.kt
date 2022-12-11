package com.example.schooldb.data.localDB.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.schooldb.data.localDB.entities.Lesson
import com.example.schooldb.data.localDB.entities.Teacher

data class TeacherWithLessons(
    @Embedded val teacher: Teacher,
    @Relation(
        parentColumn = "teacher_login",
        entityColumn = "teacher_login"
    )
    val lesson: List<Lesson>
)
