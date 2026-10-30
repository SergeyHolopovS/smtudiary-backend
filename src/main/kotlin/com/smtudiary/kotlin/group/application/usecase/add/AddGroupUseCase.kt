package com.smtudiary.kotlin.group.application.usecase.add

import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.domain.repository.GroupRepository
import org.springframework.stereotype.Component

@Component
class AddGroupUseCase(
    private val repository: GroupRepository
) {

    fun execute(command: AddGroupCommand): Group? {
        // Если группа уже существует возвращаем null
        if (repository.existsByGroup(command.group)) return null

        // Иначе возвращаем новую группу
        return repository.save(
            Group(command.group)
        )
    }

}