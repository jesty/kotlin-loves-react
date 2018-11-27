package com.starter.frontend.component.app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.router.dom.hashRouter
import react.router.dom.route
import react.router.dom.switch

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        h1("App-header") {
            +"Hello Milan Codemotion 2018!!!"
        }

        hashRouter {
            switch {
                route("/", IndexComponent::class, exact = true)
                route("/about", AboutComponent::class, exact = true)
                route("/myMovies", MyMoviesComponent::class, exact = true)
                route("/myMoviesRemote", MyMoviesRemoteComponent::class, exact = true)
                route("/github", GithubComponent::class, exact = true)
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
