package ru.otus.otustinder.common.models

data class TndrMatch(
    val tndrMatchId: TndrMatchId = TndrMatchId.NONE,
    val firstUser: TndrProfileId = TndrProfileId.NONE,
    val secondUser: TndrProfileId = TndrProfileId.NONE,
)