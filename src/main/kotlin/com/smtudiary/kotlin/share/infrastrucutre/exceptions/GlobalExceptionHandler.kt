package com.smtudiary.kotlin.share.infrastrucutre.exceptions

import com.smtudiary.kotlin.share.infrastrucutre.exceptions.basic.BasicException
import com.smtudiary.kotlin.share.infrastrucutre.exceptions.dto.ErrorDto
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BasicException::class)
    fun handleBasicException(exception: BasicException): ResponseEntity<ErrorDto> {
        return error(exception.status, exception.message)
    }

    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(exception: ResponseStatusException): ResponseEntity<ErrorDto> {
        val status = HttpStatus.valueOf(exception.statusCode.value())
        return error(status, exception.reason ?: status.reasonPhrase)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleMethodNotAllowed(exception: HttpRequestMethodNotSupportedException): ResponseEntity<ErrorDto> {
        return error(HttpStatus.METHOD_NOT_ALLOWED, exception.message ?: "Method not allowed")
    }

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleNotFound(exception: NoResourceFoundException): ResponseEntity<ErrorDto> {
        return error(HttpStatus.NOT_FOUND, exception.message ?: "Resource not found")
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(exception: MethodArgumentNotValidException): ResponseEntity<ErrorDto> {
        val message = exception.bindingResult.fieldErrors.joinToString("; ") { error: FieldError ->
            "${error.field}: ${error.defaultMessage}"
        }.ifBlank { "Validation failed" }
        return error(HttpStatus.BAD_REQUEST, message)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolation(exception: ConstraintViolationException): ResponseEntity<ErrorDto> {
        val message = exception.constraintViolations.joinToString("; ") { "${it.propertyPath}: ${it.message}" }
            .ifBlank { "Validation failed" }
        return error(HttpStatus.BAD_REQUEST, message)
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingParameter(exception: MissingServletRequestParameterException): ResponseEntity<ErrorDto> {
        return error(HttpStatus.BAD_REQUEST, exception.message ?: "Missing required parameter")
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleTypeMismatch(exception: MethodArgumentTypeMismatchException): ResponseEntity<ErrorDto> {
        val message = "Parameter '${exception.name}' has invalid value: ${exception.value}"
        return error(HttpStatus.BAD_REQUEST, message)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleNotReadable(exception: HttpMessageNotReadableException): ResponseEntity<ErrorDto> {
        return error(HttpStatus.BAD_REQUEST, "Malformed request body")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception): ResponseEntity<ErrorDto> {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, exception.message ?: "Unexpected error")
    }

    private fun error(status: HttpStatus, message: String): ResponseEntity<ErrorDto> {
        return ResponseEntity.status(status).body(
            ErrorDto(
                status = status.value(),
                error = status.reasonPhrase,
                message = message,
            )
        )
    }

}
