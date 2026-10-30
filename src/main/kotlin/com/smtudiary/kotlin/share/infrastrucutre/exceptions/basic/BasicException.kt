package com.smtudiary.kotlin.share.infrastrucutre.exceptions.basic

import org.springframework.http.HttpStatus

abstract class BasicException(
    override val message: String,
    val status: HttpStatus,
) : RuntimeException(message)
