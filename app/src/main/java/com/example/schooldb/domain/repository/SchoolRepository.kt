package com.example.schooldb.domain.repository

import com.example.schooldb.data.localDB.entities.Director
import com.example.schooldb.domain.entities.UserCredos

interface SchoolRepository {

    suspend fun loginAdmin(credos: UserCredos): Director

    suspend fun registerAdmin(credos: UserCredos)
}