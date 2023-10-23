package ru.otus.otustinder.config

import kotlinx.serialization.json.Json
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.KotlinSerializationJsonHttpMessageConverter

@ConfigurationProperties
class SerializaionConfiguration {
    @Bean
    fun messageConverter(): KotlinSerializationJsonHttpMessageConverter {
        return KotlinSerializationJsonHttpMessageConverter(Json {
            ignoreUnknownKeys = true
        })
    }
}