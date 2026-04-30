package com.kov.bunchbackend.service.impl

import com.kov.bunchbackend.service.ProfileService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

class ProfileServiceImpl : ProfileService {
    override fun getProfile(userId: UUID?): UserProfileResponse {
        TODO("Not yet implemented")
    }

    override fun updateProfile(userId: UUID?, request: UserProfileRequest): UserProfileResponse {
        TODO("Not yet implemented")
    }

    override fun updateAvatar(userId: UUID?, request: UpdateAvatarRequest): UserProfileResponse {
        TODO("Not yet implemented")
    }

    override fun getPublicProfile(userId: UUID?): UserProfileResponse {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(
        currentUserId: UUID?,
        pageable: Pageable?
    ): Page<UserProfileResponse>? {
        TODO("Not yet implemented")
    }
}