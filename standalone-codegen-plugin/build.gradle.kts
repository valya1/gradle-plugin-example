plugins {
  `kotlin-dsl`
  `maven-publish`
}

val integrationTest: SourceSet by sourceSets.creating
val functionalTest: SourceSet by sourceSets.creating

gradlePlugin {

  testSourceSets(functionalTest)

  plugins {
    register("codegen-plugin") {
      description = "Creates simple Kotlin class with message property"
      displayName = "Simple Kotlin codegen plugin"
      id = "ru.myorg.demo.codegen-plugin"
      implementationClass = "ru.myorg.demo.plugin.CodegenPlugin"
    }
  }
}

//publishing {
//  publications {
//    create<MavenPublication>("codegen-plugin") {
//      artifactId = "codegen-plugin"
//      groupId = "ru.myorg.demo"
//      version = "1.0.0"
//      from(components["kotlin"])
//    }
//  }
//
//  repositories {
//    maven {
//      name = "remote"
//      url = uri("https://some-remote-repo")
//      credentials {
//        username = project.ext["MY_REMOTE_REPO_USERNAME"] as String
//        password = project.ext["MY_REMOTE_REPO_PASSWORD"] as String
//      }
//    }
//  }
//}

repositories {
  mavenCentral()
}

val integrationTestTask = tasks.register<Test>("integrationTest") {
  description = "Runs the integration tests."
  group = "verification"
  testClassesDirs = integrationTest.output.classesDirs
  classpath = integrationTest.runtimeClasspath
  mustRunAfter(tasks.test)
}

val functionalTestTask = tasks.register<Test>("functionalTest") {
  description = "Runs the functional tests."
  group = "verification"
  testClassesDirs = functionalTest.output.classesDirs
  classpath = functionalTest.runtimeClasspath
  mustRunAfter(tasks.test)
}

tasks.check {
  dependsOn(integrationTestTask)
  dependsOn(functionalTestTask)
}

dependencies {
  "integrationTestImplementation"(project)
  "integrationTestImplementation"("junit:junit:4.12")

  "functionalTestImplementation"("junit:junit:4.12")

  testImplementation("junit:junit:4.12")
  testImplementation("io.mockk:mockk:1.11.0")

  implementation("com.squareup:kotlinpoet:1.7.2")
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
}
