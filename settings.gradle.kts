rootProject.name = "otus_tinder_lukiniv"

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings
    val springframeworkBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val pluginSpringVersion: String by settings
    val pluginJpa: String by settings
    val pluginShadow: String by settings
    val ktorVersion: String by settings
    val bmuschkoVersion: String by settings
    val openApiVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false

        id("org.springframework.boot") version springframeworkBootVersion apply false
        id("io.spring.dependency-management") version springDependencyManagementVersion apply false
        kotlin("plugin.spring") version pluginSpringVersion apply false
        kotlin("plugin.jpa") version pluginJpa apply false
        id("com.bmuschko.docker-spring-boot-application") version bmuschkoVersion apply false
        id("org.openapi.generator") version openapiVersion apply false

        id("io.ktor.plugin") version ktorVersion apply false
    }


}

include("model")