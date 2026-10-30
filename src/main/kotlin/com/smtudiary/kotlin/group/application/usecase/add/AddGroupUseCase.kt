package com.smtudiary.kotlin.group.application.usecase.add

import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.domain.repository.GroupRepository
import org.springframework.stereotype.Component

@Component
class AddGroupUseCase(
    private val repository: GroupRepository
) {

    fun execute(command: AddGroupCommand): Group
        // Сохраням новую группу в базу данных
        = repository.save(
            Group(command.group)
        )

}