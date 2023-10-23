package ru.otus.otustinder.api.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.otustinder.app.common.TndrAppSettings

@RestController
@RequestMapping("/profile")
class ProfileController(
    private val tndrSettings: TndrAppSettings
) {
    @PostMapping("create")
    suspend fun createProfile(@RequestBody request: ProfileCreateRequest): ProfileCreateResponse =
        //process(tndrSettings, request, "profile-create")
        stub(tndrSettings, request, "profile-create")

    @PostMapping("read")
    suspend fun readProfile(@RequestBody request: ProfileReadRequest): ProfileReadResponse =
        //process(tndrSettings, request, "profile-read")
        stub(tndrSettings, request, "profile-read")

    @PostMapping("update")
    suspend fun updateProfile(@RequestBody request: ProfileUpdateRequest): ProfileUpdateResponse =
        //process(tndrSettings, request, "profile-update")
        stub(tndrSettings, request, "profile-update")

    @PostMapping("delete")
    suspend fun deleteProfile(@RequestBody request: ProfileDeleteRequest): ProfileDeleteResponse =
        //process(tndrSettings, request, "profile-delete")
        stub(tndrSettings, request, "profile-delete")

    @PostMapping("next")
    suspend fun nextProfile(@RequestBody request: ProfileNextRequest): ProfileNextResponse =
        //process(tndrSettings, request, "profile-delete")
        stub(tndrSettings, request, "profile-next")

    @PostMapping("like")
    suspend fun likeProfile(@RequestBody request: ProfileLikeRequest): ProfileLikeResponse =
        //process(tndrSettings, request, "profile-like")
        stub(tndrSettings, request, "profile-like")

    @PostMapping("listMatches")
    suspend fun listMatchesProfile(@RequestBody request: ProfileMatchesRequest): ProfileMatchesResponse =
        //process(tndrSettings, request, "profile-delete")
        stub(tndrSettings, request, "profile-matches")

}