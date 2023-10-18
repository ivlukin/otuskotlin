package ru.otus.otustinder.common

import kotlinx.datetime.Instant
import ru.otus.otustinder.common.models.*
import ru.otus.otustinder.common.stubs.TndrStubs

data class TndrContext(
    var command: TndrCommand = TndrCommand.NONE,
    var state: TndrState = TndrState.NONE,
    val errors: MutableList<TndrError> = mutableListOf(),

    var workMode: TndrWorkMode = TndrWorkMode.PROD,
    var stubCase: TndrStubs = TndrStubs.NONE,


    var requestId: TndrRequestId = TndrRequestId.NONE,
    var timeStart: Instant = Instant.NONE,
    var profileRequest: TndrProfile = TndrProfile(),

    var profileResponse: TndrProfile = TndrProfile(),
    var profilesResponse: MutableList<TndrProfile> = mutableListOf(),

    var matchResponse: TndrMatch = TndrMatch(),
)
