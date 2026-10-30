package com.smtudiary.kotlin.group.infrastructure.persistence.repository

import com.smtudiary.kotlin.group.infrastructure.persistence.entity.GroupJpaEntity
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository

interface GroupJpaRepository : JpaRepository<GroupJpaEntity, Int> {

    @Cacheable(cacheNames = ["groups"])
    override fun findAll(): List<GroupJpaEntity>

    fun existsByGroup(group: Int) : Boolean

}
