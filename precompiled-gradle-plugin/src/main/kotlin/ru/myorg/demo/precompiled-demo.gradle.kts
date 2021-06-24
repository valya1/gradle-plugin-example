package ru.myorg.demo

import org.gradle.kotlin.dsl.registering

val printHelloGradle by tasks.registering {
  doLast {
    println("Hello from Gradle script-plugin!")
  }
}