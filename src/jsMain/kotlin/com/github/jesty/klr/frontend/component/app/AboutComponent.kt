package com.github.jesty.klr.frontend.component.app

import com.github.jesty.klr.Greetings
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import kotlinx.html.title
import react.*
import react.dom.*


interface AboutComponentState : RState {
    var bgcolor: String
}

class AboutComponent : RComponent<RProps, AboutComponentState>() {

    override fun componentDidMount() {
        println("Component did mount...")
    }

    override fun RBuilder.render() {

        header("About this project")

        h3 {
            +Greetings().sayGreetings()
            attrs.title = "This string came from a Expected/Actual class"
        }

        p {
            +"This projects shows how to use React with Kotlin!"
        }

        div {
            button {
                +"Click here to show an alert!"
                attrs {
                    onClickFunction = {
                        val alert: dynamic = js(
                            "{" +
                                    "showAlert:function(){" +
                                    "window.alert('This is an alert made with \"js\" function. This function will retrun a dynamic.')" +
                                    "}" +
                                    "}"
                        )
                        alert.showAlert()
                    }
                }
            }
            button {
                +"Click here to show another alert!"
                attrs {
                    onClickFunction = {
                        AlertHelper().showAlert()
                    }
                }
            }
        }

        div {
            +"Click to change my color"
            attrs {
                val color: String = state?.bgcolor ?: "green"
                jsStyle {
                    backgroundColor = color
                    width = "300px"
                    height = "40px"
                    margin = "10px 0px"
                    cursor = "grab"
                }
                onClickFunction = {
                    setState { bgcolor = randomColor() }
                }
            }
        }

        goHome()
    }

    fun randomColor(): String {
        val r = (0..255).random()
        val g = (0..255).random()
        val b = (0..255).random()
        return "#${r.toString(16)}${g.toString(16)}${b.toString(16)}"
    }
}


fun RBuilder.about() = child(AboutComponent::class) {
}
