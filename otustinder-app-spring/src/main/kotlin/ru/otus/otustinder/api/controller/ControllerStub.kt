package ru.otus.otustinder.api.controller


import kotlinx.datetime.Clock
import ru.otus.otuskotlin.marketplace.common.helpers.asTndrError
import ru.otus.otuskotlin.marketplace.common.helpers.fail
import ru.otus.otustinder.common.TndrContext
import ru.otus.otustinder.common.models.TndrCommand


suspend fun <T> stub(
    fromTransport: suspend TndrContext.() -> Unit,
    sendResponse: suspend TndrContext.() -> T,
): T {
    var command = TndrCommand.NONE
    return try {
        val ctx = TndrContext(
            timeStart = Clock.System.now(),
        )
        ctx.fromTransport()
        command = ctx.command
        ctx.sendResponse()

    } catch (e: Throwable) {

        val ctx = TndrContext(
            timeStart = Clock.System.now(),
            command = command
        )

        ctx.fail(e.asTndrError())
        sendResponse(ctx)
    }

}
