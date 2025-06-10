package com.interview.drugreport.exception

class ResourceNotFoundException(
    override val message: String? = "Resource not found"
) : RuntimeException(message)