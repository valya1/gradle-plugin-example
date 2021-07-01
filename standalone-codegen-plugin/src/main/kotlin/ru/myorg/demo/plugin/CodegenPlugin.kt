package ru.myorg.demo.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import ru.myorg.demo.task.CodegenTask

class CodegenPlugin : Plugin<Project> {

  override fun apply(target: Project) {

    val extension = target.extensions.create<CodegenPluginExtension>("simpleCodegen", target)

    with(target.tasks) {

      val codegenTask = register<CodegenTask>("codegenSimpleClass") {
        group = "Code generation"
        description = "Generates simple Kotlin class with single message property"

        packageName = extension.packageName
        messageFile = extension.messageFile.asFile
        outputDir = extension.outputDir.asFile
      }

      target.tasks.withType<KotlinCompile>().configureEach {
        dependsOn(codegenTask)
      }
    }

    target.afterEvaluate {
      (target.extensions["sourceSets"] as SourceSetContainer)["main"]
        .java
        .srcDir(extension.outputDir)
    }
  }
}