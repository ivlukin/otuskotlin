plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":otustinder-common"))
    implementation(project(":model"))

    testImplementation(kotlin("test-junit"))
}