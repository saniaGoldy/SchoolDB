package com.example.schooldb.domain.repository

import com.example.schooldb.data.localDB.SchoolDatabase
import com.example.schooldb.data.localDB.entities.Director
import com.example.schooldb.domain.entities.UserCredos
import com.example.schooldb.domain.utils.mapToDirector

class SchoolRepositoryImplementation(private val database: SchoolDatabase): SchoolRepository {
    override suspend fun loginAdmin(credos: UserCredos): Director {
        return database.schoolDao.getDirectorByLogin(credos.login)
    }

    override suspend fun registerAdmin(credos: UserCredos){
        return database.schoolDao.insertDirector(credos.mapToDirector())
    }
}