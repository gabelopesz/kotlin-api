package com.ktor

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting() {
    route("/users") {
        get {
            if (userStorage.isNotEmpty()) {
                call.respond(userStorage)
            } else {
                call.respondText("Nenhum usuário encontrado", status = HttpStatusCode.OK)
            }
        }
        get("/{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Id ausente",
                status = HttpStatusCode.BadRequest
            )
            val user =
                userStorage.find { it.id == id } ?: return@get call.respondText(
                    "Nenhum usuário com id: $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(user)
        }
        post {
            val user = call.receive<User>()
            userStorage.add(user)
            call.respondText("Usuário adicionado", status = HttpStatusCode.Created)
        }
        put("/{id}") {
            val id = call.parameters["id"] ?: return@put call.respond(HttpStatusCode.BadRequest)
            val userIndex = userStorage.indexOfFirst { it.id == id }
            if (userIndex == -1) {
                call.respondText("Usuário não encontrado", status = HttpStatusCode.NotFound)
            } else {
                val newUser = call.receive<User>()
                userStorage[userIndex] = newUser
                call.respondText("Usuário atualizado", status = HttpStatusCode.Accepted)
            }
        }
        delete("/{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            val removed = userStorage.removeIf { it.id == id }
            if (removed) {
                call.respondText("Usuário removido", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Usuário não encontrado", status = HttpStatusCode.NotFound)
            }
        }
    }
}