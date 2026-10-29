package com.smtudiary.kotlin.lesson.infrastructure.mappers

import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.infrastructure.appilcation.usecase.create.CreateLessonCommand
import com.smtudiary.kotlin.lesson.infrastructure.persistence.entity.LessonJpaEntity
import com.smtudiary.kotlin.lesson.infrastructure.web.dto.response.LessonResponse

fun Lesson.toEntity(): LessonJpaEntity
    = LessonJpaEntity(
        id = this.id,
        name = this.name,
        time = this.time,
        teacher = this.teacher,
        week = this.week,
        room = this.room,
        day = this.day,
        group = this.group
    )

fun CreateLessonCommand.toModel() : Lesson
    = Lesson(
        name = this.name,
        time = this.time,
        teacher = this.teacher,
        week = this.week,
        room = this.room,
        day = this.day,
        group = this.group
    )

fun Lesson.toResponse(): LessonResponse
    = LessonResponse(
        name = this.name,
        time = this.time,
        teacher = this.teacher,
        week = this.week,
        room = this.room,
        day = this.day,
        group = this.group
    )