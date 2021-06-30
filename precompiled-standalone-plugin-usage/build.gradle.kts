plugins {
    kotlin("jvm")
    id("ru.myorg.demo.precompiled-standalone-plugin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}
