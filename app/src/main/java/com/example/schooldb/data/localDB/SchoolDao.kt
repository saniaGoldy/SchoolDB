package com.example.schooldb.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schooldb.data.localDB.entities.Director
import com.example.schooldb.data.localDB.entities.Student

@Dao
interface SchoolDao {
    //TODO return entities via RX

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Query("SELECT * FROM director WHERE director_login = :login")
    suspend fun getDirectorByLogin(login: String): Director


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM student WHERE student_login = :login")
    suspend fun getStudentByLogin(login: String): Student

}
