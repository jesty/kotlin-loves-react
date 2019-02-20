package com.github.jesty.klr.frontend

import com.github.jesty.klr.frontend.component.app.app
import react.dom.render
import kotlin.browser.document

fun main(args: Array<String>) {
    render(
    document.getElementById("root")) {
        app()
    }
}