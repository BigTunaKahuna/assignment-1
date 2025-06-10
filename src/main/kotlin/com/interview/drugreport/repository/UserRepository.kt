package com.interview.drugreport.repository

import com.interview.drugreport.repository.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}