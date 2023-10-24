package ru.otus.otustinder.common.helpers

import ru.otus.otustinder.common.TndrContext
import ru.otus.otustinder.common.models.TndrCommand


fun TndrContext.isUpdatableCommand() =
    this.command in listOf(TndrCommand.CREATE, TndrCommand.UPDATE, TndrCommand.DELETE)
