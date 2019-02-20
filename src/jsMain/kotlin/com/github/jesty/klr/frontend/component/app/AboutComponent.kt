package com.github.jesty.klr.frontend.component.app

import com.github.jesty.klr.Greetings
import kotlinx.html.js.onClickFunction
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
                                    "window.alert('This is an alert made with \"js\" function. This function will return a dynamic.')" +
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

        h3 {
            +Greetings().sayGreetings() //finally we meet again!
            attrs.title = "This string came from a Expected/Actual class"
        }

        goHome()
    }

    fun randomColor(): String {
        val r = (0..255).random().toString(16)
        val g = (0..255).random().toString(16)
        val b = (0..255).random().toString(16)
        return "#$r$g$b"
    }
}


fun RBuilder.about() = child(AboutComponent::class) {
}
