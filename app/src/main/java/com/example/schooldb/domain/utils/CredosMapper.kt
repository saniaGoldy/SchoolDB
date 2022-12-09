package com.example.schooldb.domain.utils

import com.example.schooldb.data.localDB.entities.Director
import com.example.schooldb.domain.entities.UserCredos

fun UserCredos.mapToDirector(): Director {
    return Director(this.login, this.password, this.login)
}