package ru.otus.otustinder.mappers

import ru.otus.otustinder.api.models.*
import ru.otus.otustinder.common.TndrContext
import ru.otus.otustinder.common.models.*
import ru.otus.otustinder.mappers.exceptions.UnknownTndrCommand

fun TndrContext.toTransportProfile(): IResponse = when (val cmd = command) {
    TndrCommand.CREATE -> toTransportCreate()
    TndrCommand.READ -> toTransportRead()
    TndrCommand.UPDATE -> toTransportUpdate()
    TndrCommand.DELETE -> toTransportDelete()
    TndrCommand.LIKE -> toTransportLike()
    TndrCommand.NEXT -> toTransportNext()
    TndrCommand.LIST_MATCHES -> toTransportMatches()
    TndrCommand.NONE -> throw UnknownTndrCommand(cmd)
}

fun TndrContext.toTransportCreate() = ProfileCreateResponse(
    responseType = "create",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    profile = profileResponse.toTransportProfile()
)

fun TndrContext.toTransportRead() = ProfileReadResponse(
    responseType = "read",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    profile = profileResponse.toTransportProfile()
)

fun TndrContext.toTransportUpdate() = ProfileUpdateResponse(
    responseType = "update",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    profile = profileResponse.toTransportProfile()
)

fun TndrContext.toTransportDelete() = ProfileDeleteResponse(
    responseType = "delete",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    profile = profileResponse.toTransportProfile()
)

fun TndrContext.toTransportLike() = ProfileLikeResponse(
    responseType = "like",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    info = profileResponse.info.map { UserAttribute(name = it.name, value = it.value) },
    addInfo = profileResponse.addInfo.map { UserAttribute(name = it.name, value = it.value) },
    isMatch = profileResponse.likes.stream().anyMatch { it.asString() == this.profileRequest.id.asString() },
    match = Match(this.profileRequest.id.asString(), this.profileResponse.id.asString())
)

fun TndrContext.toTransportNext() = ProfileNextResponse(
    responseType = "next",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    profile = this.profileResponse.toTransportProfile()
)

fun TndrContext.toTransportMatches() = ProfileMatchesResponse(
    responseType = "list_matches",
    requestId = this.requestId.asString().takeIf { it.isNotBlank() },
    result = if (state == TndrState.FINISHING) ResponseResult.SUCCESS else ResponseResult.ERROR,
    errors = errors.toTransportErrors(),
    profileList = this.profilesResponse.map {it.toTransportProfile()}
)

private fun TndrProfile.toTransportProfile(): ProfileResponseObject = ProfileResponseObject(
    id = id.takeIf { it != TndrProfileId.NONE }?.asString(),
    lock = lock.takeIf { it != TndrProfileLock.NONE }?.asString(),
    info = info.map { UserAttribute(name = it.name, value = it.value) },
    addInfo = addInfo.map { UserAttribute(name = it.name, value = it.value) },
)


private fun List<TndrError>.toTransportErrors(): List<Error>? = this
    .map { it.toTransportProfile() }
    .toList()
    .takeIf { it.isNotEmpty() }

private fun TndrError.toTransportProfile() = Error(
    code = code.takeIf { it.isNotBlank() },
    group = group.takeIf { it.isNotBlank() },
    field = field.takeIf { it.isNotBlank() },
    message = message.takeIf { it.isNotBlank() },
)
