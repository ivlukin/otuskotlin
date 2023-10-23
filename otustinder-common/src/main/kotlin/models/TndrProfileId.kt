package ru.otus.otustinder.common.models

import kotlin.jvm.JvmInline

@JvmInline
value class TndrProfileId(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = TndrProfileId("")
    }
}
