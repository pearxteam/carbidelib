plugins {
    id("kotlin-gradle-plugin") apply false
    base
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