package com.starter.githubapi

import kotlin.js.Promise

@JsModule("github-api")
external class GitHub(user: User) {
    fun getUser(): GHUser
}

@JsModule("github-api")
external class GHUser {
    fun listStarredRepos(): Promise<Result>
}