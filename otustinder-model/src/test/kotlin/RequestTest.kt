import org.junit.Test
import ru.otus.otustinder.api.models.*
import kotlin.test.assertContains
import kotlin.test.assertEquals

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

    @Test
    fun serialize() {
        val json = apiMapper.writeValueAsString(request)

        assertContains(json, Regex("\"stub\":\\s*\"notFound\""))
        assertContains(json, Regex("\"requestType\":\\s*\"create\""))
        assertContains(json, Regex("\"name\":\\s*\"zodiac\""))
    }

    @Test
    fun deserialize() {
        val json = apiMapper.writeValueAsString(request)
        val obj = apiMapper.readValue(json, IRequest::class.java) as ProfileCreateRequest

        assertEquals(request, obj)
    }
}