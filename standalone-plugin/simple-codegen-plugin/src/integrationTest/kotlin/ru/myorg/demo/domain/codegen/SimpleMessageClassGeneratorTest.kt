package ru.myorg.demo.domain.codegen

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import ru.myorg.demo.domain.messageProvider.MessageProvider
import java.io.File

class SimpleMessageClassGeneratorTest {

  @get:Rule
  val tempFolder = TemporaryFolder()

  @Test
  fun verifyCorrectKotlinFileCreated() {

    val message = "Hello!"
    val messageProvider = MessageProvider { message }
    val simpleMessageClassGenerator = SimpleMessageClassGenerator(messageProvider)

    val expectedKotlinClass = "package ru.myorg.demo\n" +
        "\n" +
        "import kotlin.String\n" +
        "\n" +
        "public class SimpleClass {\n" +
        "  public val message: String = \"Hello!\"\n" +
        "}\n"

    simpleMessageClassGenerator.generate(
      packageName = "ru.myorg.demo",
      outputDir = tempFolder.root
    )

    val generatedFile = File(tempFolder.root, "/ru/myorg/demo/SimpleClass.kt")

    assert(generatedFile.exists() && generatedFile.readText() == expectedKotlinClass)
  }

}