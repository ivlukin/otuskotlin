package ru.otus.otustinder.api.controller

import com.ninjasquad.springmockk.MockkBean
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import ru.otus.otustinder.api.models.*
import ru.otus.otustinder.app.common.TndrAppSettings
import ru.otus.otustinder.common.TndrContext
import ru.otus.otustinder.mappers.*

@WebFluxTest(ProfileController::class)
internal class ProfileControllerTest {

    @Autowired
    private lateinit var webClient: WebTestClient

    @MockkBean(relaxUnitFun = true)
    private lateinit var appSettings: TndrAppSettings

    @Test
    fun createProfile() = testStubProfile(
        "/profile/create",
        ProfileCreateRequest(),
        TndrContext().toTransportCreate()
    )

    @Test
    fun readProfile() = testStubProfile(
        "/profile/read",
        ProfileReadRequest(),
        TndrContext().toTransportRead()
    )

    @Test
    fun updateProfile() = testStubProfile(
        "/profile/update",
        ProfileUpdateRequest(),
        TndrContext().toTransportUpdate()
    )

    @Test
    fun deleteProfile() = testStubProfile(
        "/profile/delete",
        ProfileCreateRequest(),
        TndrContext().toTransportDelete()
    )

    @Test
    fun nextProfile() = testStubProfile(
        "/profile/next",
        ProfileNextRequest(),
        TndrContext().toTransportNext()
    )

    @Test
    fun likeProfile() = testStubProfile(
        "/profile/like",
        ProfileLikeRequest(),
        TndrContext().toTransportCreate()
    )
    @Test
    fun listMatchesProfile() = testStubProfile(
        "/profile/listMatches",
        ProfileMatchesRequest(),
        TndrContext().toTransportCreate()
    )

    private inline fun <reified Req : Any, reified Res : IResponse> testStubProfile(
        url: String,
        req: Req,
        res: Res
    ) {
        webClient
            .post()
            .uri(url)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(req))
            .exchange()
            .expectStatus().isOk
            .expectBody(Res::class.java)
            .value {
                println("RESPONSE: $it")
                Assertions.assertThat(it).isEqualTo(res)
            }
    }
}