package ru.otus.otustinder.app.common
import org.springframework.context.annotation.Configuration

@Configuration
data class TndrAppSettings(
    val appUrls: List<String> = emptyList(),
)
