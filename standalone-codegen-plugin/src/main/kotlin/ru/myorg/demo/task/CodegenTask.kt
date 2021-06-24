package ru.myorg.demo.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import ru.myorg.demo.domain.messageDecorator.LoveGradleMessageDecorator
import ru.myorg.demo.domain.messageProvider.FileDecoratedMessageProvider
import ru.myorg.demo.domain.codegen.SimpleMessageClassGenerator
import java.io.File

open class CodegenTask : DefaultTask() {

  @get:InputFile
  lateinit var messageFile: File

  @get:Input
  lateinit var packageName: String

  @get:OutputDirectory
  lateinit var outputDir: File

  @TaskAction
  fun invoke() {
    val messageDecorator = LoveGradleMessageDecorator()
    val messageProvider = FileDecoratedMessageProvider(messageFile, messageDecorator)
    val simpleFileGenerator = SimpleMessageClassGenerator(messageProvider)

    simpleFileGenerator.generate(packageName, outputDir)
  }

}