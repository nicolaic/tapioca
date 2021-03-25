[license-badge]: https://img.shields.io/github/license/nicolaic/tapioca.svg
[actions-badge]: https://github.com/nicolaic/tapioca/actions/workflows/gradle.yml/badge.svg
[actions-gradle]: https://github.com/nicolaic/tapioca/actions/workflows/gradle.yml

# Tapioca [![License][license-badge]](/LICENSE) [![Kotlin CI with Gradle][actions-badge]][actions-gradle]
A simple platform adaptable key/mouse to actions binding library.


### Features

##### Add the repository

```kotlin
repositories {
    mavenCentral()
}
```

##### Install the dependency

```kotlin
dependencies {
    implementation("dev.nicolai:tapioca:{current_version}")
}
```

## How it works

Tapioca use a concept of bindable actions, that you can bind to an key/button
with optional key modifiers. You can obtain a bindable action by asking the
bindings system to create one for you. The bindings system provides a function
that will create a bindable action when given an id and an action. The id
serves two purposes, it simplifies the serialization, and it allows you to
lookup any action by id.
