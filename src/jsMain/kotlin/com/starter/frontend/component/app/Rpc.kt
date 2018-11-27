package com.starter.frontend.component.app

import com.starter.common.Movie
import org.w3c.fetch.RequestInit
import kotlin.browser.window
import kotlin.js.Promise
import kotlin.js.json

fun loadMovies(): Promise<List<Movie>> =
    getAndParseResult("http://localhost:8080/movies", null, ::parseToSnippets)

private fun parseToSnippets(json: dynamic): List<Movie> {
    var result: MutableList<Movie> = mutableListOf()
    for (item in json.movies){
        result.add(parseObject(item))
    }
    return result
}

private fun parseObject(json: dynamic): Movie {
    return Movie(json.title, json.year, json.director)
}

fun <T> getAndParseResult(url: String, body: dynamic, parse: (dynamic) -> T): Promise<T> =
    requestAndParseResult("GET", url, body, parse)

fun <T> requestAndParseResult(method: String, url: String, body: dynamic, parse: (dynamic) -> T): Promise<T> {
    val response = window.fetch(url, object : RequestInit {
        override var method: String? = method
        override var body: dynamic = body
        //override var credentials: RequestCredentials? = "same-origin".asDynamic()
        override var headers: dynamic = json("Accept" to "application/json")
    })

    return response
        .then{ it.json() }
        .then { parse(it) }

}