package com.starter.frontend.component.app

import com.starter.common.Movie
import react.*
import react.dom.li
import react.dom.ul

interface MyMoviesRemoteComponentState : RState {
    var movies: List<Movie>
}

class MyMoviesRemoteComponent : RComponent<RProps, MyMoviesRemoteComponentState>() {

    init {
        loadData()
    }

    fun loadData() {
        loadMovies()
            .then {
                setState {
                    movies = it
                }
            }
    }

    override fun RBuilder.render() {
        header("My movies (remote)")

        ul {
            state.movies?.forEach { li { +"${it.title} (${it.year}) - ${it.director}" } }
        }

        goHome()
    }
}

fun RBuilder.myMoviesRemote() = child(MyMoviesRemoteComponent::class) {
}
