package com.smtudiary.kotlin.lesson.domain.model

import java.util.UUID

data class Lesson(
    val id : UUID? = null,
    val name : String?,
    val time : String,
    val teacher : String?,
    val week: WeekType,
    val room : String,
    val group : String,
    val day: String,
)
