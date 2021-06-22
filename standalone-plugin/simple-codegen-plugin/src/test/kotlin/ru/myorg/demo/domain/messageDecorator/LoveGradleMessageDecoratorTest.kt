package ru.myorg.demo.domain.messageDecorator

import org.junit.Test
import ru.myorg.demo.domain.messageDecorator.LoveGradleMessageDecorator

class LoveGradleMessageDecoratorTest {

  private val messageDecorator = LoveGradleMessageDecorator()

  @Test
  fun `prints Love Gradle at the end `() {
    val testMessage = "test"
    val expectedResultMessage = "test\nLove Gradle"
    val resultMessage = messageDecorator.decorate(testMessage)
    assert(resultMessage == expectedResultMessage)
  }

}