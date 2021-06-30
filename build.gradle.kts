plugins {
  kotlin("jvm") version "1.5.10"
  id("ru.myorg.demo.codegen-plugin")
  id("ru.myorg.demo.precompiled-demo")
}

simpleCodegen {
  messageFile = layout.projectDirectory.file("message.txt")
  packageName = "ru.myorg.example"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
}