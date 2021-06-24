package ru.myorg.demo.domain.codegen

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.myorg.demo.domain.messageProvider.MessageProvider
import java.io.File

class SimpleMessageClassGenerator(private val messageProvider: MessageProvider) {

  fun generate(packageName: String, outputDir: File) {

    val className = "SimpleClass"
    val message = messageProvider.provide()

    val kotlinFileSpecBuilder = FileSpec.builder(packageName, className)

    val classBuilder = TypeSpec.classBuilder(className)
    val property = PropertySpec.builder("message", String::class)
      .initializer("\"$message\"")
      .build()

    val clazz = classBuilder.addProperty(property).build()

    val kotlinFileSpec = kotlinFileSpecBuilder.addType(clazz).build()
    kotlinFileSpec.writeTo(outputDir)
  }
}
