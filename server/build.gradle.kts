plugins {
    application
    kotlin("jvm")
    id("io.ktor.plugin") version "2.3.4"
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}




dependencies {
    val postgresql_version: String by project
    implementation("org.postgresql:postgresql:$postgresql_version")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.8.10")

    val springdocOpenapiUiVersion: String by project

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.1.0")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus:1.10.5")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("com.h2database:h2:2.1.214")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocOpenapiUiVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
