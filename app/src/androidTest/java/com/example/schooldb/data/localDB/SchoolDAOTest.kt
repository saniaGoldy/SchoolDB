package com.example.schooldb.data.localDB

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.schooldb.data.localDB.entities.*
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
internal class SchoolDAOTest : KoinTest {

    val schoolDatabase: SchoolDatabase by inject()
    val schoolDao: SchoolDao by inject()

    @AfterEach
    fun teardown() {
        schoolDatabase.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveDirector() = runTest {
        val director = Director("login", "password", "name")

        schoolDao.insertDirector(director)

        val requestedEntry = schoolDao.getDirectorByLogin("login")

        assertThat(requestedEntry).isEqualTo(director)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveStudent() = runTest {
        val student = Student("login", "password", 0, "name")

        schoolDao.insertStudent(student)

        val requestedEntry = schoolDao.getStudentByLogin("login")

        assertThat(requestedEntry).isEqualTo(student)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveSchoolClass() = runTest {
        val schoolClass = SchoolClass(0, "name")

        schoolDao.insertSchoolClass(schoolClass)

        val requestedEntry = schoolDao.getSchoolClassById(0)

        assertThat(requestedEntry).isEqualTo(schoolClass)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveLesson() = runTest {
        val lesson = Lesson(0, "name", 0, "login", "time", 0)

        schoolDao.insertLesson(lesson)

        val requestedEntry = schoolDao.getLessonById(0)

        assertThat(requestedEntry).isEqualTo(lesson)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveJournal() = runTest {
        val expected = Journal(0, 0, "login", "A")

        schoolDao.insertJournalEntry(expected)

        val requestedEntry = schoolDao.getJournalEntryById(0)

        assertThat(requestedEntry).isEqualTo(expected)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveTeacher() = runTest {
        val expected = Teacher("login", "password", "name", 0)

        schoolDao.insertTeacher(expected)

        val requestedEntry = schoolDao.getTeacherByLogin("login")

        assertThat(requestedEntry).isEqualTo(expected)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveSchoolClassWithLessons() = runTest {
        val lesson1 = Lesson(0, "name", 0, "login", "time", 0)
        val lesson2 = Lesson(1, "name2", 0, "login", "time1", 1)
        val schoolClass = SchoolClass(0, "name")

        schoolDao.insertLesson(lesson1)
        schoolDao.insertLesson(lesson2)
        schoolDao.insertSchoolClass(schoolClass)

        val requestedEntry = schoolDao.getSchoolClassWithLessonsBySchoolClassId(0)

        assertThat(requestedEntry.size).isEqualTo(1)
        assertThat(requestedEntry[0].schoolClass).isEqualTo(schoolClass)
        assertThat(requestedEntry[0].lessons).isEqualTo(listOf(lesson1, lesson2))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveTeacherAndLesson() = runTest {
        val lesson1 = Lesson(0, "name", 0, "login", "time", 0)
        val lesson2 = Lesson(1, "name2", 1, "login", "time1", 1)
        val teacher = Teacher("login", "password", "name", 0)

        schoolDao.insertLesson(lesson1)
        schoolDao.insertLesson(lesson2)
        schoolDao.insertTeacher(teacher)

        val requestedEntry = schoolDao.getTeacherWithLessonsByTeacherLogin("login")

        assertThat(requestedEntry.size).isEqualTo(1)
        assertThat(requestedEntry[0].teacher).isEqualTo(teacher)
        assertThat(requestedEntry[0].lesson[0]).isEqualTo(lesson1)
        assertThat(requestedEntry[0].lesson[1]).isEqualTo(lesson2)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveSchoolClassWithStudents() = runTest {
        val student1 = Student("login", "password", 0, "name")
        val student2 = Student("login1", "password", 0, "name")
        val schoolClass = SchoolClass(0, "name")

        schoolDao.insertStudent(student1)
        schoolDao.insertStudent(student2)
        schoolDao.insertSchoolClass(schoolClass)

        val requestedEntry = schoolDao.getSchoolClassWithStudentsByClassId(0)

        assertThat(requestedEntry.size).isEqualTo(1)
        assertThat(requestedEntry[0].schoolClass).isEqualTo(schoolClass)
        assertThat(requestedEntry[0].students[0]).isEqualTo(student1)
        assertThat(requestedEntry[0].students[1]).isEqualTo(student2)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun saveAndRetrieveDisciplineWithLessons() = runTest {
        val lesson1 = Lesson(0, "name", 0, "login", "time", 0)
        val lesson2 = Lesson(1, "name2", 0, "login", "time1", 0)
        val discipline = Discipline(0, "name")

        schoolDao.insertLesson(lesson1)
        schoolDao.insertLesson(lesson2)
        schoolDao.insertDiscipline(discipline)

        val requestedEntry = schoolDao.getDisciplineWithLessonsByDisciplineId(0)

        assertThat(requestedEntry.size).isEqualTo(1)
        assertThat(requestedEntry[0].discipline).isEqualTo(discipline)
        assertThat(requestedEntry[0].lessons).isEqualTo(listOf(lesson1, lesson2))
    }
}