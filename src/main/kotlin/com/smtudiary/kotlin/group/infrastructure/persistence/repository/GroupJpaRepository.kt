package com.smtudiary.kotlin.group.infrastructure.persistence.repository

import com.smtudiary.kotlin.group.infrastructure.persistence.entity.GroupJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GroupJpaRepository : JpaRepository<GroupJpaEntity, Int> {
}