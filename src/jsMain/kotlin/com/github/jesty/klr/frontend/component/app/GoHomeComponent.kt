package com.github.jesty.klr.frontend.component.app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h2
import react.dom.p
import react.router.dom.routeLink

class GoHomeComponent : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        routeLink("/") { +"[Home]" }
    }
}

fun RBuilder.goHome() = child(GoHomeComponent::class) {
}
