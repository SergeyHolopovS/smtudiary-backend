package com.smtudiary.kotlin.group.infrastructure.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "groups")
data class GroupJpaEntity(
    @Id
    val group: Int
)
