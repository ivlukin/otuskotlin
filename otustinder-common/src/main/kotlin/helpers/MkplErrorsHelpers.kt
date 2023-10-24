package ru.otus.otuskotlin.marketplace.common.helpers

import ru.otus.otustinder.common.TndrContext
import ru.otus.otustinder.common.models.TndrError
import ru.otus.otustinder.common.models.TndrProfileLock
import ru.otus.otustinder.common.models.TndrState


fun Throwable.asTndrError(
    code: String = "unknown",
    group: String = "exceptions",
    message: String = this.message ?: "",
) = TndrError(
    code = code,
    group = group,
    field = "",
    message = message,
    exception = this,
)

fun TndrContext.addError(vararg error: TndrError) = errors.addAll(error)

fun TndrContext.fail(error: TndrError) {
    addError(error)
    state = TndrState.FAILING
}

fun errorValidation(
    field: String,
    /**
     * Код, характеризующий ошибку. Не должен включать имя поля или указание на валидацию.
     * Например: empty, badSymbols, tooLong, etc
     */
    violationCode: String,
    description: String,
    level: TndrError.Level = TndrError.Level.ERROR,
) = TndrError(
    code = "validation-$field-$violationCode",
    field = field,
    group = "validation",
    message = "Validation error for field $field: $description",
    level = level,
)

fun errorAdministration(
    /**
     * Код, характеризующий ошибку. Не должен включать имя поля или указание на валидацию.
     * Например: empty, badSymbols, tooLong, etc
     */
    field: String = "",
    violationCode: String,
    description: String,
    exception: Exception? = null,
    level: TndrError.Level = TndrError.Level.ERROR,
) = TndrError(
    field = field,
    code = "administration-$violationCode",
    group = "administration",
    message = "Microservice management error: $description",
    level = level,
    exception = exception,
)

fun errorRepoConcurrency(
    expectedLock: TndrProfileLock,
    actualLock: TndrProfileLock?,
    exception: Exception? = null,
) = TndrError(
    field = "lock",
    code = "concurrency",
    group = "repo",
    message = "The object has been changed concurrently by another user or process",
    exception = exception,
)

val errorNotFound = TndrError(
    field = "id",
    message = "Not Found",
    code = "not-found"
)

val errorEmptyId = TndrError(
    field = "id",
    message = "Id must not be null or blank"
)
