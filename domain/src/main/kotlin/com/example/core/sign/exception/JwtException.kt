package com.example.core.sign.exception

sealed class JwtException(
    override val message: String,
) : RuntimeException(message)

data class ParseJwtFailedException(
    override val message: String,
) : JwtException(message)

data class ExpiredJwtException(
    override val message: String,
) : JwtException(message)

data class NoBearerTokenException(
    override val message: String,
) : JwtException(message)
