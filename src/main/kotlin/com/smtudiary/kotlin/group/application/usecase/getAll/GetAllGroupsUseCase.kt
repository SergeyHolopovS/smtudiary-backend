package com.smtudiary.kotlin.group.application.usecase.getAll

import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.domain.repository.GroupRepository
import org.springframework.stereotype.Component

@Component
class GetAllGroupsUseCase(
    private val repository: GroupRepository
) {

    fun execute(): List<Group> =
        // Возвращаем все группы из базы данных
        repository.getAllGroups()

}