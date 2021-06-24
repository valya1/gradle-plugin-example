package ru.myorg.demo.plugin

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

class CodegenPluginTest {

  @get:Rule
  val tempFolder = TemporaryFolder()

  @Test
  fun canSuccessfullyPrintMessageToFileInProjectDir() {

    /**
     * Готовим build.gradle
     */
    val generatedPackageName = "ru.myorg.demo.example"
    val buildGradleFile = tempFolder.newFile("build.gradle.kts")
    buildGradleFile.printWriter()
      .use {
        it.print(
          "plugins {\n" +
              "  kotlin(\"jvm\") version \"1.5.10\"\n" +
              "  id(\"ru.myorg.demo.codegen-plugin\")\n" +
              "}\n" +
              "\n" +
              "simpleCodegen {\n" +
              "  messageFile = layout.projectDirectory.file(\"message.txt\").asFile\n" +
              "  packageName = \"$generatedPackageName\"\n" +
              "}\n" +
              "\n" +
              "repositories {\n" +
              "  mavenCentral()\n" +
              "}\n" +
              "\n" +
              "dependencies {\n" +
              "  implementation(kotlin(\"stdlib\"))\n" +
              "}\n"
        )
      }


    /**
     * Готовим сообщение message
     */
    val messageFileName = "message.txt"
    val messageFile = tempFolder.newFile(messageFileName)
    messageFile.bufferedWriter().write("Hello!")

    /**
     * Запускаем Gradle Daemon и билдим проект.
     */
    GradleRunner.create()
      .withProjectDir(tempFolder.root)
      .withArguments("build")
      .withPluginClasspath()
      .build()


    /**
     * Смотрим, что создалось. Содержимое файла мы уже проверили в интеграционном тесте.
     */
    val outputFile =
      File(
        tempFolder.root,
        "/build/src-gen/" + generatedPackageName.replace('.', '/') + "/SimpleClass.kt"
      )

    assert(outputFile.exists())
  }

}