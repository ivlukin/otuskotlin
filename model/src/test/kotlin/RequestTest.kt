import ru.otus.otustinder.api.models.*

class RequestTest {
    private val request = ProfileCreateRequest(
        requestId = "qwerty123",
        debug = ProfileDebug(
            mode = ProfileRequestDebugMode.STUB,
            stub = ProfileRequestDebugStubs.NOT_FOUND
        ),
        profile = ProfileCreateObject(
            info = listOf(UserAttribute("age", "21"), UserAttribute("name", "Paul")),
            addInfo = listOf(UserAttribute("zodiac", "gemini"))
        )
    )
}