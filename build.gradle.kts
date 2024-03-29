import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile


plugins {
    kotlin("jvm")
}

val javaVersion: String by project

group = "ru.otus.otustinder"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        gradlePluginPortal()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = javaVersion
    }
    tasks.withType<KotlinJvmCompile> {
        kotlinOptions.jvmTarget = javaVersion
    }
}

