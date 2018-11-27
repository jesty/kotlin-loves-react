package com.github.jesty.klr

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.util.*

val movies = Collections.synchronizedList(mutableListOf(
    Movie("Old Boy", 2003, "Park Chan-wook"),
    Movie("Pulp fiction", 1994, "Quentin Tarantino")
))

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT) // Pretty Prints the JSON
            }
            install(CORS)
            {
                method(HttpMethod.Options)
                header(HttpHeaders.XForwardedProto)
                anyHost()
            }
        }
        routing {
            get("/movies") {
                call.respond(mapOf("movies" to synchronized(movies) { movies.toList() }))
            }

            get("/greetings") {
                call.respond(Greetings().sayGreetings())
            }
        }
    }
    server.start(wait = true)
}