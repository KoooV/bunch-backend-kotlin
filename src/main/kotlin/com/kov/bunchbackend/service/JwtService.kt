package com.kov.bunchbackend.service

import com.kov.bunchbackend.model.RefreshToken
import com.kov.bunchbackend.model.User
import java.time.Instant
import java.util.function.Function

interface JwtService {

    fun <T> extractClaim(token: String?, claimsResolver: Function<MutableMap<String?, Any?>?, T?>?): T?

    fun extractAllClaims(token: String?): Claims?

    fun generateAccessToken(user: User?, refreshToken: RefreshToken?, now: Instant?, expiration: Instant?): String?

    fun generateRefreshToken(user: User?, now: Instant?, expiration: Instant?): String?

    fun tokenIsValid(token: String?): Boolean
}