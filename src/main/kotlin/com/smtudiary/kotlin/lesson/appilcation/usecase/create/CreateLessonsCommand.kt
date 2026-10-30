package com.smtudiary.kotlin.lesson.appilcation.usecase.create

import com.smtudiary.kotlin.lesson.domain.model.WeekType

data class CreateLessonCommand(
    val name : String?,
    val time : String,
    val teacher : String?,
    val week: WeekType,
    val room : String,
    val group : String,
    val day: String,
)

data class CreateLessonsCommand(
    val lessons: List<CreateLessonCommand>,
)
