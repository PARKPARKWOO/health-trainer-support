package com.example.core.sign.application.service

import com.example.common.constants.Constants
import com.example.common.jwt.JwtResponseDto
import com.example.common.jwt.JwtTokenService
import com.example.core.common.error.ErrorCode
import com.example.core.common.error.ServiceException
import com.example.core.common.redis.RedisDriver
import com.example.core.sign.application.port.`in`.SignInUserUseCase
import com.example.core.sign.application.port.`in`.command.SignInWithEmailCommand
import com.example.domain.constants.DomainConstants
import org.springframework.beans.factory.annotation.Value

abstract class AbstractSignInService(
    private val redisDriver: RedisDriver,
    @Value("\${jwt.refresh-token.expire-millis}")
    private val refreshTokenExpireTime: Long,
    private val jwtTokenService: JwtTokenService,
) : SignInUserUseCase {
    abstract override fun findUser(command: SignInWithEmailCommand): Map<String, Any>

    override fun signInWithEmail(command: SignInWithEmailCommand): JwtResponseDto {
        val claim = findUser(command)
        val token = jwtTokenService.build(claim)
        saveRefreshToken(token.refreshToken, claim[DomainConstants.USER_ID].toString())
        return token
    }

    private fun saveRefreshToken(refreshToken: String, id: String) {
        redisDriver.setValue(
            key = Constants.REFRESH_TOKEN_PREFIX + id,
            value = refreshToken,
            ttl = refreshTokenExpireTime,
        )
    }
}
