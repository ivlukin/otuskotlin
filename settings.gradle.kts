rootProject.name = "otus_tinder_lukiniv"

pluginManagement {
    val kotlinVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
    }
}

include("server")
include("database")