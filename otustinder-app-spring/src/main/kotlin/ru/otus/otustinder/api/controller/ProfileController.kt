package ru.otus.otustinder.api.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.otustinder.api.models.*
import ru.otus.otustinder.app.common.TndrAppSettings
import ru.otus.otustinder.mappers.fromTransport
import ru.otus.otustinder.mappers.toTransportProfile

@RestController
@RequestMapping("/profile")
class ProfileController(
    private val tndrSettings: TndrAppSettings
) {
    @PostMapping("create")
    suspend fun createProfile(@RequestBody request: ProfileCreateRequest): ProfileCreateResponse =
        //process(tndrSettings, request, "profile-create")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileCreateResponse }
        )

    @PostMapping("read")
    suspend fun readProfile(@RequestBody request: ProfileReadRequest): ProfileReadResponse =
        //process(tndrSettings, request, "profile-read")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileReadResponse }
        )

    @PostMapping("update")
    suspend fun updateProfile(@RequestBody request: ProfileUpdateRequest): ProfileUpdateResponse =
        //process(tndrSettings, request, "profile-update")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileUpdateResponse }
        )

    @PostMapping("delete")
    suspend fun deleteProfile(@RequestBody request: ProfileDeleteRequest): ProfileDeleteResponse =
        //process(tndrSettings, request, "profile-delete")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileDeleteResponse }
        )

    @PostMapping("next")
    suspend fun nextProfile(@RequestBody request: ProfileNextRequest): ProfileNextResponse =
        //process(tndrSettings, request, "profile-delete")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileNextResponse }
        )

    @PostMapping("like")
    suspend fun likeProfile(@RequestBody request: ProfileLikeRequest): ProfileLikeResponse =
        //process(tndrSettings, request, "profile-like")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileLikeResponse }
        )

    @PostMapping("listMatches")
    suspend fun listMatchesProfile(@RequestBody request: ProfileMatchesRequest): ProfileMatchesResponse =
        //process(tndrSettings, request, "profile-delete")
        stub(
            fromTransport = {
                fromTransport(request)
            },
            sendResponse = { toTransportProfile() as ProfileMatchesResponse }
        )
}