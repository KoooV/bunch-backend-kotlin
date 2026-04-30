package com.kov.bunchbackend.dto.response

import java.util.*

data class UserProfileResponse(
    var id: UUID? = null,
    var username: String? = null,
    var email: String? = null,
    var avatarUrl: String? = null
)
