package com.github.jesty.klr.frontend.component.app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h2

interface HeaderComponentProps : RProps {
    var title: String
}

class HeaderComponent : RComponent<HeaderComponentProps, RState>() {

    override fun RBuilder.render() {
        h2 {
            +props.title
        }
    }
}

fun RBuilder.header(title: String) = child(HeaderComponent::class) {
    attrs.title = title
}
