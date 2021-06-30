package ru.myorg.demo.plugin

import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

fun PluginDependenciesSpec.codegenPlugin(): PluginDependencySpec =
  id("ru.myorg.demo.codegen-plugin")