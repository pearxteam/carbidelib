plugins {
    base
    id("kotlin-gradle-plugin") apply false
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