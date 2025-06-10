package com.interview.drugreport.service

import com.interview.drugreport.dto.UserRegistrationRequest
import com.interview.drugreport.repository.UserRepository
import com.interview.drugreport.repository.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(request: UserRegistrationRequest): User {
        val user = User(
            username = request.username,
            password = passwordEncoder.encode(request.password),
            authorities = setOf("ROLE_USER")
        )
        return userRepository.save(user)
    }
}