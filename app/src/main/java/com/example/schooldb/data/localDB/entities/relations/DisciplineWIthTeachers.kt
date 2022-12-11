package com.example.schooldb.data.localDB.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.schooldb.data.localDB.entities.Discipline
import com.example.schooldb.data.localDB.entities.Teacher

data class DisciplineWIthTeachers(
    @Embedded val discipline: Discipline,
    @Relation(
        parentColumn = "discipline_id",
        entityColumn = "discipline_id"
    )
    val teachers: List<Teacher>
)
