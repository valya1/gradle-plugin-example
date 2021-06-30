plugins {
  kotlin("jvm")
  id("ru.myorg.demo.codegen-plugin")
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