plugins {
    kotlin("jvm")
}




dependencies {
    val postgresql_version: String by project
    implementation("org.postgresql:postgresql:$postgresql_version")
}