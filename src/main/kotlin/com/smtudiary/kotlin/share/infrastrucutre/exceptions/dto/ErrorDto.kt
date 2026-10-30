package com.smtudiary.kotlin.share.infrastrucutre.exceptions.dto

import java.time.Instant

data class ErrorDto(
    val status: Int,
    val error: String,
    val message: String,
    val timestamp: Instant = Instant.now(),
)
