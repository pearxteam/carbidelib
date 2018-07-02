val kotlin_version: String by settings

pluginManagement {
    repositories {
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if(requested.id.id == "kotlin-gradle-plugin")
            {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
            }
        }
    }
}

include("platform:js", "platform:jvm", "platform:common")