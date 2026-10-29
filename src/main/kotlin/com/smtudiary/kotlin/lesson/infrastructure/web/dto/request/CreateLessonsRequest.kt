package com.smtudiary.kotlin.lesson.infrastructure.web.dto.request

data class CreateLessonsRequest(
    val apikey: String,
    val lessons: List<CreateLessonRequest>
)
