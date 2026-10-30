package com.smtudiary.kotlin.group.infrastructure.persistence.repository

import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.domain.repository.GroupRepository
import com.smtudiary.kotlin.group.infrastructure.mappers.toEntity
import com.smtudiary.kotlin.group.infrastructure.mappers.toModel
import com.smtudiary.kotlin.group.infrastructure.persistence.entity.GroupJpaEntity
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Repository

@Repository
class GroupRepositoryImpl(
    private val repository: GroupJpaRepository
) : GroupRepository {
    override fun getAllGroups(): List<Group>
        = repository.findAll().map(GroupJpaEntity::toModel)

    override fun existsByGroup(group: Int): Boolean
        = repository.existsByGroup(group)

    @CacheEvict(cacheNames = ["groups"], allEntries = true)
    override fun save(group: Group): Group
        = repository.save(group.toEntity()).toModel()
}