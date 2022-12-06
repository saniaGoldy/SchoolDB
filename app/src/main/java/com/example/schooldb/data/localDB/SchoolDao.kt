package com.example.schooldb.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.schooldb.data.localDB.entities.Director

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    //"SELECT * FROM director WHERE login LIKE :login"
    @Query("SELECT * FROM director WHERE login = :login")
    suspend fun getDirectorByLogin(login: String): Director
}
