package com.smtudiary.kotlin.lesson.appilcation.usecase.getByGroup

import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.domain.model.WeekType
import com.smtudiary.kotlin.lesson.domain.repository.LessonRepository
import org.springframework.stereotype.Component
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

@Component
class GetLessonsByGroupUseCase(
    private val repository: LessonRepository
) {

    fun execute(command: GetLessonsByGroupCommand): List<Lesson>
        // Ищем занятия по группе и возвращаем
        = repository.findByGroup(command.group)

}