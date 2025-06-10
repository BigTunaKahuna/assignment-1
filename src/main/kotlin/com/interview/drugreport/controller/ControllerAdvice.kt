package com.interview.drugreport.controller

import com.interview.drugreport.exception.ResourceNotFoundException
import com.interview.drugreport.exception.ProblemDetails
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest
import java.net.URI
import java.time.Instant

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(value = [ResourceNotFoundException::class])
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun resourceNotFoundException(ex: ResourceNotFoundException, request: WebRequest): ProblemDetails {
        val servletRequest = request as ServletWebRequest
        return ProblemDetails(
            type = "urn:problem-type:resource-not-found",
            title = "Resource not found",
            status = HttpStatus.NOT_FOUND.value(),
            detail = ex.message,
            instance = servletRequest.request.requestURI
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: WebRequest): ProblemDetails {
        val servletRequest = request as ServletWebRequest
        return ProblemDetails(
            type = "urn:problem-type:internal-server-error",
            title = "Unexpected error",
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            detail = "An unexpected error occurred",
            instance = servletRequest.request.requestURI
        )
    }
}