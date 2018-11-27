package com.starter.frontend.component.app

import com.starter.githubapi.GitHub
import com.starter.githubapi.Result
import com.starter.githubapi.User
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.onChange
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.*

interface GithubComponentState : RState {
    var starredRepos: Result
    var username: String
    var password: String
    var logged: Boolean
}

class GithubComponent : RComponent<RProps, GithubComponentState>() {

    init {
        state.logged = false
    }

    override fun RBuilder.render() {

        header("My starred repos")

        if (!state.logged) {
            fieldSet {
                legend { +"Github credentials" }

                label { +"Username: " }
                input {
                    attrs {
                        type = InputType.text
                        onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState { username = target.value }
                        }
                    }
                }

                label { +"Password: " }
                input {
                    attrs {
                        type = InputType.password
                        onChangeFunction = {
                            val target = it.target as HTMLInputElement
                            setState { password = target.value }
                        }
                    }
                }

                button {
                    +"Login"
                    attrs.onClickFunction = {
                        val gh = GitHub(User(state.username, state.password))
                        gh.getUser()
                            .listStarredRepos()
                            .then {
                                setState {
                                    starredRepos = it
                                    logged = true
                                }
                            }
                    }
                }
            }
        } else {
            button {
                +"Logout"
                attrs.onClickFunction = {
                    setState { logged = false }
                }
            }

            ul {
                state.starredRepos?.data?.forEach {
                    li { +"Starred: ${it.id}: ${it.name}" }
                }
            }
        }

        goHome()
    }
}

fun RBuilder.github() = child(GithubComponent::class) {
}
