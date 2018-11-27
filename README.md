
## Intro

This projects shows how to setup a multi-platform application with Kotlin and React.
This repository starts from: https://github.com/gbaldeck/react-js-jvm-kotlin-multiplatform, but it is extended writing some
effective examples about Kotlin and React. There are some interaction with a simple REST API built using Ktor.


## Kotlin/JS Module

First, run:
> npm install

Then the Gradle task:
> gradlew runDceJsKotlin

Then for webpack dev-server do:
> npm run serve

Once it's running you can view it in the browser by going to `localhost:9000`

For production build do:
> npm run prod-build

While the dev server is running you can run the `runDceJsKotlin` gradle task and it will automatically pick up the emitted Kotlin/JS files.

To automatically launch the `runDceJsKotlin` gradle task when the code changes, do:
> gradlew runDceJsKotlin -t

The builds include JS source maps for the Kotlin/JS files as well. So you can setup a run configuration in IntelliJ to debug in the IDE or you can debug in your favorite browser's dev tools, whichever you prefer.
