package com.smtudiary.kotlin.group.infrastructure.mappers

import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.infrastructure.persistence.entity.GroupJpaEntity
import com.smtudiary.kotlin.group.infrastructure.web.dto.response.GroupResponse

fun Group.toEntity(): GroupJpaEntity =
    GroupJpaEntity(
        group = this.number
    )

fun GroupJpaEntity.toModel(): Group =
    Group(
        this.group
    )

fun Group.toResponse(): GroupResponse
    = GroupResponse(
        group = this.number
    )