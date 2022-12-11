package com.example.schooldb.data.localDB.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.schooldb.data.localDB.entities.SchoolClass
import com.example.schooldb.data.localDB.entities.Student

data class SchoolClassWithStudents(
    @Embedded val schoolClass: SchoolClass,
    @Relation(
        parentColumn = "school_class_id",
        entityColumn = "school_class_id"
    )
    val students: List<Student>
)
