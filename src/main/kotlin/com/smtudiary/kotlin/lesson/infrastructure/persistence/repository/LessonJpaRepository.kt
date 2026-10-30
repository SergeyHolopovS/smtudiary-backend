package com.smtudiary.kotlin.lesson.infrastructure.persistence.repository

import com.smtudiary.kotlin.lesson.infrastructure.persistence.entity.LessonJpaEntity
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LessonJpaRepository: JpaRepository<LessonJpaEntity, UUID> {

    @Cacheable(cacheNames = ["lessons"], key = "#group")
    fun findByGroupGroup(group: Int): List<LessonJpaEntity>

}