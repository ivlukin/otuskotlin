import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
}

val javaVersion: String by project

group = "ru.otus.otuskotlin.marketplace"
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

