package ru.myorg.demo.domain.messageDecorator

import org.junit.Test

class LoveGradleMessageDecoratorTest {

  private val messageDecorator = LoveGradleMessageDecorator()

  @Test
  fun `prints Love Gradle at the end `() {
    val testMessage = "test"
    val expectedResultMessage = "test Love Gradle"
    val resultMessage = messageDecorator.decorate(testMessage)
    assert(resultMessage == expectedResultMessage)
  }

}