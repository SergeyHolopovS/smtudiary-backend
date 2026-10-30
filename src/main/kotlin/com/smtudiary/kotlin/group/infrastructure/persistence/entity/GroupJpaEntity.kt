package com.smtudiary.kotlin.group.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "groups")
data class GroupJpaEntity(
    @Id
    @Column(name = "`group`")
    val group: Int
) : Serializable
