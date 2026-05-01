package com.kov.bunchbackend.repository

import com.kov.bunchbackend.model.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RefreshTokenRepository : JpaRepository<RefreshToken, UUID> {
    fun findByToken(token: String) : RefreshToken?

    @Modifying
    @Query(value = """
        UPDATE refresh_tokens
        SET revoked = true
        WHERE user_id = :userId
    """, nativeQuery = true)
    fun revokeAllByUserId(@Param("userId") userId: UUID)

    @Modifying
    @Query("""
        UPDATE refresh_tokens
        SET revoked = true
        WHERE token = :token
    """, nativeQuery = true)
    fun revokeByToken(@Param("token") token: String)

    @Query("""
        SELECT token FROM refresh_tokens
        WHERE userId = :userId
        AND revoked = false
        AND expireAt > now()
    """, nativeQuery = true)
    fun findAllByValidTokenByUserId(@Param("userId") userId: UUID) : List<RefreshToken>



}