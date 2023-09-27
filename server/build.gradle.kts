plugins {
    application
    kotlin("jvm")
    id("io.ktor.plugin")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("plugin.serialization")
    id("com.bmuschko.docker-spring-boot-application")
}




dependencies {
    val kotestVersion: String by project
    val postgresql_version: String by project


    implementation("org.postgresql:postgresql:$postgresql_version")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.10")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.10")

    val springdocOpenapiUiVersion: String by project

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation:")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus:1.10.5")

    runtimeOnly("com.h2database:h2:2.1.220")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocOpenapiUiVersion")

    // tests
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.4")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux") // Controller, Service, etc..
    testImplementation("com.ninja-squad:springmockk:4.0.2") // mockking beans
}

tasks.withType<Test> {
    useJUnitPlatform()
}
