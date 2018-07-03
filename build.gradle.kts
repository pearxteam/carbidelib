plugins {
    base
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${properties["kotlin_version"]}")
    }
}

subprojects {
    apply(plugin = "base")

    repositories {
        mavenCentral()
    }

    base {
        archivesBaseName = "carbidelib-$archivesBaseName"
    }
}