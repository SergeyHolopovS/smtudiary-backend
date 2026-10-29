package com.smtudiary.kotlin.lesson.infrastructure.appilcation.usecase.create

import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.domain.repository.LessonRepository
import com.smtudiary.kotlin.lesson.infrastructure.mappers.toModel
import org.springframework.stereotype.Component

@Component
class CreateLessonsUseCase(
    private val repository: LessonRepository
) {

    fun execute(command: CreateLessonsCommand): List<Lesson>
        // Маппим команду в модель и сохраняем через репозиторий (безопастность на уровне контроллера)
        = repository.saveAll(command.lessons.map { it.toModel() })

}