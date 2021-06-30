package ru.myorg.demo

val helloTask by tasks.registering {
  doLast {
    println("Hello!")
  }
}