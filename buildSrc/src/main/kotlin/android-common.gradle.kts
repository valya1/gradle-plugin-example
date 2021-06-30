plugins {
  id("com.android.library")
  id("kotlin-android")
}

android {
  compileSdkVersion(androidCompileSdkVersion)
  buildToolsVersion(androidBuildToolsVersion)

  defaultConfig {
    minSdkVersion(androidMinSdkVersion)
    targetSdkVersion(androidTargetSdkVersion)
  }

  sourceSets["main"].java.srcDirs("src/main/kotlin")
  sourceSets["test"].java.srcDirs("src/test/kotlin")


  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
}
