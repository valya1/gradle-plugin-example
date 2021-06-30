package ru.myorg.demo.plugin

import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

abstract class CodegenPluginExtension(project: Project) {

  var messageFile: RegularFile
    get() = messageFileProperty.get()
    set(value) = messageFileProperty.set(value)

  var outputDir: Directory
    get() = outputDirProperty.get()
    set(value) = outputDirProperty.set(value)

  var packageName: String
    get() = packageNameProperty.get()
    set(value) = packageNameProperty.set(value)

  private val objects = project.objects

  internal val packageNameProperty: Property<String> = objects.property<String>()
    .convention("ru.myorg.demo")

  internal val messageFileProperty = objects.fileProperty()

  internal val outputDirProperty = objects.directoryProperty()
    .convention(project.layout.buildDirectory.dir("src-gen"))

}