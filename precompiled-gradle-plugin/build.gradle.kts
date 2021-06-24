plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib"))
}
