package com.ktor

import kotlinx.serialization.Serializable

@Serializable
data class User(val id: String, val firstName: String, val lastName: String, val email: String)

val userStorage = mutableListOf(
    User("1", "Joao", "Silva","teste@teste.com"),
    User("2", "Maria", "Souza","teste2@teste.com")
)