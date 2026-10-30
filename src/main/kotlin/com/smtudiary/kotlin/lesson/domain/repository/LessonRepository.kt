package com.smtudiary.kotlin.lesson.domain.repository

import com.smtudiary.kotlin.lesson.domain.model.Lesson

interface LessonRepository {

    fun saveAll(lessons: List<Lesson>): List<Lesson>

    fun findByGroup(group: Int): List<Lesson>

    fun clearDb()

}