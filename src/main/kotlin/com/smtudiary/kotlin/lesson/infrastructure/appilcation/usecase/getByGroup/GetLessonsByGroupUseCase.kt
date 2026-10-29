package com.smtudiary.kotlin.lesson.infrastructure.appilcation.usecase.getByGroup

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

    private fun currentWeekType(now: Instant = Instant.now()): WeekType {
        // Получаем текущие дату и время
        val today = now.atZone(ZoneId.of("Europe/Moscow")).toLocalDate()

        // Учебный год начинается 1 сентября текущего года или прошлого, если сейчас раньше
        val year = if (today >= LocalDate.of(today.year, 9, 1)) today.year else today.year - 1
        val sept1 = LocalDate.of(year, 9, 1)

        // Понедельник недели, в которую попадает 1 сентября
        val weekStart = sept1.minusDays((sept1.dayOfWeek.value - DayOfWeek.MONDAY.value).toLong())

        // Считаем прошедшие недели и выдаём результат
        val weeksPassed = ChronoUnit.DAYS.between(weekStart, today) / 7
        return if (weeksPassed % 2 == 0L) WeekType.UPPER else WeekType.LOWER
    }

}