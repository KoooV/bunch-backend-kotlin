package com.kov.bunchbackend.service.impl

import com.kov.bunchbackend.model.RefreshToken
import com.kov.bunchbackend.model.User
import com.kov.bunchbackend.service.JwtService
import java.time.Instant
import java.util.function.Function

class JwtServiceImpl : JwtService {
    override fun <T> extractClaim(
        token: String?,
        claimsResolver: Function<MutableMap<String?, Any?>?, T?>?
    ): T? {
        TODO("Not yet implemented")
    }

    override fun extractAllClaims(token: String?): Claims {
        TODO("Not yet implemented")
    }

    override fun generateAccessToken(
        user: User?,
        refreshToken: RefreshToken?,
        now: Instant?,
        expiration: Instant?
    ): String? {
        TODO("Not yet implemented")
    }

    override fun generateRefreshToken(
        user: User?,
        now: Instant?,
        expiration: Instant?
    ): String? {
        TODO("Not yet implemented")
    }

    override fun tokenIsValid(token: String?): Boolean {
        TODO("Not yet implemented")
    }
}