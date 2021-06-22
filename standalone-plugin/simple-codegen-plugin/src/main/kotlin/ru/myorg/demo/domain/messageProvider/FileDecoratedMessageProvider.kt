package ru.myorg.demo.domain.messageProvider

import ru.myorg.demo.domain.messageDecorator.LoveGradleMessageDecorator
import java.io.File

class FileDecoratedMessageProvider(
  private val messageFile: File,
  private val loveGradleMessageDecorator: LoveGradleMessageDecorator
) : MessageProvider {

  override fun provide(): String {
    val fileMessage = messageFile.bufferedReader().readText()
    return loveGradleMessageDecorator.decorate(fileMessage)
  }
}
