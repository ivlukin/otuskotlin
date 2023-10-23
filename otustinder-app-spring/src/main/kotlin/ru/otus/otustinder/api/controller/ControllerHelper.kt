package ru.otus.otustinder.api.controller

import ru.otus.otustinder.app.common.TndrAppSettings

suspend inline fun <reified Q : IRequest, reified R : IResponse> stub(
    appSettings: TndrAppSettings,
    request: Q,
    logId: String,
): R = IResponse(

)