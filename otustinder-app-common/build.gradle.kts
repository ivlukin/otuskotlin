plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.serialization")
    id("com.bmuschko.docker-spring-boot-application")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator") // info; refresh; springMvc output
    implementation("org.springframework.boot:spring-boot-starter-web") // Controller, Service, etc..
    implementation("org.springframework.boot:spring-boot-starter-websocket") // Controller, Service, etc..


     //transport models
    implementation(project(":otustinder-common"))

     //api
    implementation(project(":model"))
    implementation(project(":otustinder-mappers"))

}