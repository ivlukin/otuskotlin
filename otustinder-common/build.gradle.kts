plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

kotlin {
    sourceSets {
        val datetimeVersion: String by project

        val main by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))

                api("org.jetbrains.kotlinx:kotlinx-datetime:$datetimeVersion")
            }
        }
    }
}
