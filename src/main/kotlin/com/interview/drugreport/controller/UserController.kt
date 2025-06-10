package com.interview.drugreport.controller

import com.interview.drugreport.dto.UserRegistrationRequest
import com.interview.drugreport.repository.model.User
import com.interview.drugreport.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody request: UserRegistrationRequest): User {
        return userService.register(request)
    }
}