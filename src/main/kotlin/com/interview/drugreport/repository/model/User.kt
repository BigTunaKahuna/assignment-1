package com.interview.drugreport.repository.model

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Id
    @Column(length = 50)
    val username: String = "",

    @Column(nullable = false, length = 100)
    val password: String = "",

    @Column(nullable = false)
    val enabled: Boolean = true,

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "authorities",
        joinColumns = [JoinColumn(name = "username", referencedColumnName = "username")]
    )
    @Column(name = "authority", length = 50, nullable = false)
    val authorities: Set<String> = mutableSetOf()
)
