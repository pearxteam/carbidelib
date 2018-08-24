include("platform:js", "platform:jvm", "platform:common")
rootProject.name = "carbidelib"

val nodejs_plugin_version: String by settings
val kotlin_version: String by settings

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if(requested.id.id == "com.moowork.node")
                useVersion(nodejs_plugin_version)
            if(requested.id.id.startsWith("kotlin-platform-"))
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        }
    }
}