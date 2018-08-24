subprojects {
    apply<BasePlugin>()

    repositories {
        mavenCentral()
    }

    configure<BasePluginConvention> {
        archivesBaseName = "carbidelib-$archivesBaseName"
    }
}
