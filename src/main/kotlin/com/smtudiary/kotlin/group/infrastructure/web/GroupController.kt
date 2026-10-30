package com.smtudiary.kotlin.group.infrastructure.web

import com.smtudiary.kotlin.group.application.usecase.getAll.GetAllGroupsUseCase
import com.smtudiary.kotlin.group.domain.model.Group
import com.smtudiary.kotlin.group.infrastructure.mappers.toResponse
import com.smtudiary.kotlin.group.infrastructure.web.dto.response.GroupResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/groups")
class GroupController(
    private val getAll: GetAllGroupsUseCase
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<GroupResponse>>
        = ResponseEntity.ok(getAll.execute().map(Group::toResponse))

}