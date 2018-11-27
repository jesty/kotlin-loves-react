package com.starter.frontend.component.app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.p
import react.router.dom.routeLink

class AboutComponent : RComponent<RProps, RState>() {

    override fun RBuilder.render() {

        header("About this project")

        p {
            +"This projects shows how to use React with Kotlin!"
        }

        goHome()
    }
}

fun RBuilder.about() = child(AboutComponent::class) {
}
