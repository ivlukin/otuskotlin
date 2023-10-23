package ru.otus.otustinder.mappers

import ru.otus.otustinder.api.models.*
import ru.otus.otustinder.common.TndrContext
import ru.otus.otustinder.common.models.*
import ru.otus.otustinder.common.stubs.TndrStubs
import ru.otus.otustinder.mappers.exceptions.UnknownRequestClass
import java.util.UUID.randomUUID


fun TndrContext.fromTransport(request: IRequest) = when (request) {
    is ProfileCreateRequest -> fromTransport(request)
    is ProfileReadRequest -> fromTransport(request)
    is ProfileUpdateRequest -> fromTransport(request)
    is ProfileDeleteRequest -> fromTransport(request)
    is ProfileNextRequest -> fromTransport(request)
    is ProfileLikeRequest -> fromTransport(request)
    is ProfileMatchesRequest -> fromTransport(request)
    else -> throw UnknownRequestClass(request.javaClass)
}

private fun String?.toTndrProfileId() = this?.let { TndrProfileId(it) } ?: TndrProfileId.NONE
private fun String?.toTndrProfileWithId() = TndrProfile(id = this.toTndrProfileId())
private fun String?.toTndrLock() = this?.let { TndrProfileLock(it) } ?: TndrProfileLock.NONE
private fun IRequest?.requestId() = this?.requestId?.let { TndrRequestId(it) } ?: TndrRequestId.NONE

private fun ProfileDebug?.transportToWorkMode(): TndrWorkMode = when (this?.mode) {
    ProfileRequestDebugMode.PROD -> TndrWorkMode.PROD
    ProfileRequestDebugMode.TEST -> TndrWorkMode.TEST
    ProfileRequestDebugMode.STUB -> TndrWorkMode.STUB
    null -> TndrWorkMode.PROD
}

private fun ProfileDebug?.transportToStubCase(): TndrStubs = when (this?.stub) {
    ProfileRequestDebugStubs.SUCCESS -> TndrStubs.SUCCESS
    ProfileRequestDebugStubs.NOT_FOUND -> TndrStubs.NOT_FOUND
    ProfileRequestDebugStubs.BAD_ID -> TndrStubs.BAD_ID
    ProfileRequestDebugStubs.CANNOT_DELETE -> TndrStubs.CANNOT_DELETE
    ProfileRequestDebugStubs.BAD_INFO -> TndrStubs.BAD_INFO
    ProfileRequestDebugStubs.DB_ERROR -> TndrStubs.DB_ERROR
    null -> TndrStubs.NONE
}

fun TndrContext.fromTransport(request: ProfileCreateRequest) {
    command = TndrCommand.CREATE
    requestId = request.requestId()
    profileRequest = request.profile?.toInternal() ?: TndrProfile()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun TndrContext.fromTransport(request: ProfileReadRequest) {
    command = TndrCommand.READ
    requestId = request.requestId()
    profileRequest = request.profile.toInternal()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()

}

private fun ProfileReadObject?.toInternal(): TndrProfile = if (this != null) {
    TndrProfile(id = id.toTndrProfileId())
} else {
    TndrProfile.NONE
}


fun TndrContext.fromTransport(request: ProfileUpdateRequest) {
    command = TndrCommand.UPDATE
    requestId = request.requestId()
    profileRequest = request.profile?.toInternal() ?: TndrProfile()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

fun TndrContext.fromTransport(request: ProfileDeleteRequest) {
    command = TndrCommand.DELETE
    requestId = request.requestId()
    profileRequest = request.profile.toInternal()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

private fun ProfileDeleteObject?.toInternal(): TndrProfile = if (this != null) {
    TndrProfile(
        id = id.toTndrProfileId(),
        lock = lock.toTndrLock(),
    )
} else {
    TndrProfile.NONE
}

private fun TndrContext.fromTransport(request: ProfileNextRequest) {
    command = TndrCommand.NEXT
    requestId = request.requestId()
    profileRequest = request.profileId.toTndrProfileWithId()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

private fun TndrContext.fromTransport(request: ProfileLikeRequest) {
    command = TndrCommand.LIKE
    requestId = request.requestId()
    profileRequest = request.profileId.toTndrProfileWithId()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}

private fun TndrContext.fromTransport(request: ProfileMatchesRequest) {
    command = TndrCommand.LIST_MATCHES
    requestId = request.requestId()
    profileRequest = request.profileId.toTndrProfileWithId()
    workMode = request.debug.transportToWorkMode()
    stubCase = request.debug.transportToStubCase()
}


private fun ProfileCreateObject.toInternal(): TndrProfile = TndrProfile(
    info = this.info?.map {
        TndrUserAttribute(
        name = it.name ?: "",
        value = it.value ?: ""
    ) } ?: emptyList(),
    addInfo = this.addInfo?.map {
        TndrUserAttribute(
            name = it.name ?: "",
            value = it.value ?: ""
        )
    } ?: emptyList(),
    id = TndrProfileId(randomUUID().toString())
)

private fun ProfileUpdateObject.toInternal(): TndrProfile = TndrProfile(
    id = this.id.toTndrProfileId(),
    lock = lock.toTndrLock(),
    info = this.info?.map {
        TndrUserAttribute(
            name = it.name ?: "",
            value = it.value ?: ""
        ) } ?: emptyList(),
    addInfo = this.addInfo?.map {
        TndrUserAttribute(
            name = it.name ?: "",
            value = it.value ?: ""
        )
    } ?: emptyList()
)


