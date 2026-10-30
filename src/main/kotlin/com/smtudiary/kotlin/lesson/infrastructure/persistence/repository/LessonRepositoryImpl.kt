package com.smtudiary.kotlin.lesson.infrastructure.persistence.repository

import com.smtudiary.kotlin.lesson.domain.model.Lesson
import com.smtudiary.kotlin.lesson.domain.repository.LessonRepository
import com.smtudiary.kotlin.lesson.infrastructure.mappers.toEntity
import com.smtudiary.kotlin.lesson.infrastructure.mappers.toModel
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Repository

@Repository
class LessonRepositoryImpl(
    private val repository: LessonJpaRepository
) : LessonRepository {

    @CacheEvict(cacheNames = ["lessons"], allEntries = true)
    override fun saveAll(lessons: List<Lesson>): List<Lesson> {
        repository.deleteAll()

        return repository.saveAll(
            lessons.map(Lesson::toEntity)
        ).map { it.toModel() }
    }

    override fun findByGroup(group: Int): List<Lesson>
        = repository.findByGroupGroup(group).map { it.toModel() }

    override fun clearDb()
        = repository.deleteAll()

}