package ru.otus.otustinder.common.models

class TndrMatchId(private val id: String) {
    fun asString() = id

    companion object {
        val NONE = TndrMatchId("")
    }
}