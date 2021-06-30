plugins {
  `kotlin-dsl`
}

repositories {
  mavenCentral()
  google()
}

dependencies {
  runtimeOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
  implementation("com.android.tools.build:gradle:4.1.2")
  implementation(kotlin("stdlib"))
}