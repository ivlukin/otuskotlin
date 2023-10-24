import org.junit.Test
import ru.otus.otustinder.api.models.IResponse
import ru.otus.otustinder.api.models.ProfileCreateResponse
import ru.otus.otustinder.api.models.ProfileResponseObject
import ru.otus.otustinder.api.models.UserAttribute
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ResponseTest {
    private val response = ProfileCreateResponse(
        requestId = "42",
        profile = ProfileResponseObject(
            info = listOf(UserAttribute("age", "21"), UserAttribute("name", "Paul")),
            addInfo = listOf(UserAttribute("zodiac", "gemini")),
            id = "profileRandomId"
        )
    )

    @Test
    fun serialize() {
        val json = apiMapper.writeValueAsString(response)

        assertContains(json, Regex("\"value\":\\s*\"gemini\""))
        assertContains(json, Regex("\"responseType\":\\s*\"create\""))
    }

    @Test
    fun deserialize() {
        val json = apiMapper.writeValueAsString(response)
        val obj = apiMapper.readValue(json, IResponse::class.java) as ProfileCreateResponse

        assertEquals(response, obj)
    }
}