package com.smtudiary.kotlin.lesson.appilcation.usecase.create

import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.domain.repository.GroupRepository
import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.domain.repository.LessonRepository
import com.smtudiary.kotlin.lesson.infrastructure.mappers.toModel
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateLessonsUseCase(
    private val repository: LessonRepository,
    private val groupRepository: GroupRepository
) {

    @Transactional
    fun execute(command: CreateLessonsCommand): List<Lesson> {
        // Добавляем в таблицу групп те группы из занятий, которых там ещё нет
        val existing = groupRepository.getAllGroups().map(Group::number).toSet()
        command.lessons
            .map { it.group }
            .distinct()
            .filter { it !in existing }
            .forEach { groupRepository.save(Group(it)) }

        // Маппим команду в модель и сохраняем через репозиторий (безопастность на уровне контроллера)
        return repository.saveAll(command.lessons.map { it.toModel() })
    }

}
