package com.starter.frontend.component.app

import com.starter.common.Movie
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.li
import react.dom.ul

class MyMoviesComponent : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        val movies = mutableListOf(
            Movie("Old Boy", 2003, "Park Chan-wook"),
            Movie("Pulp fiction", 1994, "Quentin Tarantino"),
            Movie("Up", 2009, "Pete Docter, Bob Peterson")
        )

        header("My movies")

        ul {
            movies.forEach {
                val (title, year, director) = it
                li {
                    +"Movie: $title - $year - $director"
                }
            }
        }
        goHome()
    }
}

fun RBuilder.myMovies() = child(MyMoviesComponent::class) {
}
