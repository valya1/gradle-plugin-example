pluginManagement {
  includeBuild("standalone-codegen-plugin")
  includeBuild("standalone-precompiled-gradle-plugin")
}

rootProject.name = "gradle-plugins-example"
include("android-common-plugin-usage")
include("precompiled-standalone-plugin-usage")
