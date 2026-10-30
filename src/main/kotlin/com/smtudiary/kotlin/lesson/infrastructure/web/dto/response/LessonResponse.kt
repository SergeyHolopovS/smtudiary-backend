package com.smtudiary.kotlin.lesson.infrastructure.web.dto.response

import com.smtudiary.kotlin.lesson.domain.model.WeekType

data class LessonResponse(
    val name : String?,
    val time : String,
    val teacher : String?,
    val week: WeekType,
    val room : String,
    val group : Int,
    val day: String,
)
