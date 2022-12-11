package com.example.schooldb.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.schooldb.data.localDB.entities.*
import com.example.schooldb.data.localDB.entities.relations.*

@Dao
interface SchoolDao {
    //TODO return entities via RX

    // Insert / Get by primary key queries
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Query("SELECT * FROM director WHERE director_login = :login")
    suspend fun getDirectorByLogin(login: String): Director


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM student WHERE student_login = :login")
    suspend fun getStudentByLogin(login: String): Student

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacher: Teacher)

    @Query("SELECT * FROM teacher WHERE teacher_login = :login")
    suspend fun getTeacherByLogin(login: String): Teacher

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLesson(lesson: Lesson)

    @Query("SELECT * FROM lesson WHERE lesson_id = :lessonId")
    suspend fun getLessonById(lessonId: Int): Lesson


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchoolClass(schoolClass: SchoolClass)

    @Query("SELECT * FROM schoolclass WHERE school_class_id = :schoolClassId")
    suspend fun getSchoolClassById(schoolClassId: Int): SchoolClass


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiscipline(discipline: Discipline)

    @Query("SELECT * FROM discipline WHERE discipline_id = :disciplineId")
    suspend fun getDisciplineById(disciplineId: Int): Discipline


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJournalEntry(journal: Journal)

    @Query("SELECT * FROM journal WHERE journal_id = :journalId")
    suspend fun getJournalEntryById(journalId: Int): Journal

    //Queries for relations
    @Transaction
    @Query("SELECT * FROM discipline WHERE discipline_id = :disciplineId")
    suspend fun getDisciplineWithLessonsByDisciplineId(disciplineId: Int): List<DisciplineWithLessons>

    @Transaction
    @Query("SELECT * FROM schoolclass WHERE school_class_id = :schoolClassId")
    suspend fun getSchoolClassWithLessonsBySchoolClassId(schoolClassId: Int): List<SchoolClassWithLessons>

    @Transaction
    @Query("SELECT * FROM teacher WHERE teacher_login = :teacherLogin")
    suspend fun getTeacherWithLessonsByTeacherLogin(teacherLogin: String): List<TeacherWithLessons>

    @Transaction
    @Query("SELECT * FROM schoolclass WHERE school_class_id = :schoolClassId")
    suspend fun getSchoolClassWithStudentsByClassId(schoolClassId: Int): List<SchoolClassWithStudents>
}
