package ru.myorg.demo.plugin

import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

abstract class CodegenPluginExtension(project: Project) {

  private val objects = project.objects

  private val packageNameProp: Property<String> = objects.property<String>()
    .convention("ru.myorg.demo")

  private val messageFileProperty = objects.fileProperty()

  private val outputDirProperty = objects.directoryProperty()
    .convention(project.layout.buildDirectory.dir("src-gen"))

  var messageFile: RegularFile
    get() = messageFileProperty.get()
    set(value) = messageFileProperty.set(value)

  var outputDir: Directory
    get() = outputDirProperty.get()
    set(value) = outputDirProperty.set(value)

  var packageName: String
    get() = packageNameProp.get()
    set(value) = packageNameProp.set(value)

}