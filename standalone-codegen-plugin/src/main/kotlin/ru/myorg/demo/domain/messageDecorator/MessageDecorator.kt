package ru.myorg.demo.domain.messageDecorator

interface MessageDecorator {

  fun decorate(message: String): String
}