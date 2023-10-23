package ru.otus.otustinder.mappers.exceptions

import ru.otus.otustinder.common.models.TndrCommand


class UnknownTndrCommand(command: TndrCommand) : Throwable("Wrong command $command at mapping toTransport stage")
