package com.smtudiary.kotlin.group.domain.repository

import com.smtudiary.kotlin.group.domain.model.Group

interface GroupRepository {

    fun getAllGroups() : List<Group>

    fun existsByGroup(group: Int) : Boolean

    fun save (group: Group) : Group

}