package ru.myorg.demo.domain.messageDecorator

class LoveGradleMessageDecorator : MessageDecorator {

  override fun decorate(message: String): String = "$message Love Gradle"
}