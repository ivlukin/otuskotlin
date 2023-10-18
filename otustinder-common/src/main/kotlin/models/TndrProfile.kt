package ru.otus.otustinder.common.models

import kotlinx.datetime.Instant
import ru.otus.otustinder.common.NONE

data class TndrProfile(
    var id: TndrProfileId = TndrProfileId.NONE,
    var timePublished: Instant = Instant.NONE,
    var timeUpdated: Instant = Instant.NONE,
    var lock: TndrProfileLock = TndrProfileLock.NONE,

    val info: List<TndrUserAttribute> = emptyList(),
    val addInfo: List<TndrUserAttribute> = emptyList(),
    val matches: List<TndrMatch> = emptyList(),
    val likes: List<TndrProfileId> = emptyList()

) {
    fun isEmpty() = this == NONE

    companion object {
        val NONE = TndrProfile()
    }
}

