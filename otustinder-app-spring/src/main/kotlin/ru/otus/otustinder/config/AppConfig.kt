package ru.otus.otustinder.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(SerializaionConfiguration::class)
class AppConfig {
}