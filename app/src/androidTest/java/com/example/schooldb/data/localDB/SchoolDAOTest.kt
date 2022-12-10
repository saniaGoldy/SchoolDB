package com.example.schooldb.data.localDB

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.schooldb.data.localDB.entities.Director
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
internal class SchoolDAOTest: KoinTest{

    val schoolDatabase: SchoolDatabase by inject()
    val schoolDao: SchoolDao by inject()

    @AfterEach
    fun teardown(){
        schoolDatabase.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveDirector() = runTest{
        val director = Director("login", "password", "name")

        schoolDao.insertDirector(director)

        val requestedEntry = schoolDao.getDirectorByLogin("login")

        assertThat(requestedEntry).isEqualTo(director)
    }
}