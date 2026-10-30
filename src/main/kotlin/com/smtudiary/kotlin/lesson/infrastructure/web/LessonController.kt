package com.smtudiary.kotlin.lesson.infrastructure.web

import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.appilcation.usecase.create.CreateLessonCommand
import com.smtudiary.kotlin.lesson.appilcation.usecase.create.CreateLessonsCommand
import com.smtudiary.kotlin.lesson.appilcation.usecase.create.CreateLessonsUseCase
import com.smtudiary.kotlin.lesson.appilcation.usecase.getByGroup.GetLessonsByGroupCommand
import com.smtudiary.kotlin.lesson.appilcation.usecase.getByGroup.GetLessonsByGroupUseCase
import com.smtudiary.kotlin.lesson.infrastructure.mappers.toResponse
import com.smtudiary.kotlin.lesson.infrastructure.web.dto.request.CreateLessonsRequest
import com.smtudiary.kotlin.lesson.infrastructure.web.dto.response.LessonResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/lessons")
class LessonController(
    private val createLessons: CreateLessonsUseCase,
    private val getLessonsByGroup: GetLessonsByGroupUseCase,
    @Value($$"${app.apikey}") private val apikey: String
) {

    @PostMapping
    fun create(@RequestBody body: CreateLessonsRequest): ResponseEntity<List<LessonResponse>> {
        if (body.apikey != apikey) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid apikey")
        }

        val result = createLessons.execute(
            command = CreateLessonsCommand(
                lessons = body.lessons.map {
                    CreateLessonCommand(
                        name = it.name,
                        time = it.time,
                        teacher = it.teacher,
                        week = it.week,
                        room = it.room,
                        day = it.day,
                        group = it.group
                    )
                }
            )
        )

        return ResponseEntity.ok(result.map(Lesson::toResponse))
    }

    @GetMapping("/{group}")
    fun getByGroup(@PathVariable("group") group: String): ResponseEntity<List<LessonResponse>> {
        val result = getLessonsByGroup.execute(
            command = GetLessonsByGroupCommand(
                group = group
            )
        )

        return ResponseEntity.ok(result.map(Lesson::toResponse))
    }

}