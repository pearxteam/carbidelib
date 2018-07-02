plugins {
    id("kotlin-platform-js")
}

dependencies {
    compile(kotlin("stdlib-js"))
    expectedBy(parent!!.project("common"))
}