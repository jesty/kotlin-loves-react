package com.starter.frontend.component.app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.li
import react.dom.ul
import react.router.dom.routeLink

class IndexComponent : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div {
            +"bla bla bla bla!!!"
        }
        ul {
            li { routeLink("/about") { +"About" } }
            li { routeLink("/myMovies") { +"My movies" } }
            li { routeLink("/myMoviesRemote") { +"My movies (remote)" } }
            li { routeLink("/github") { +"My starred projects" } }
        }
    }
}


fun RBuilder.index() = child(IndexComponent::class) {
}