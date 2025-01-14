package com.example.core.user.dto

import com.example.core.user.model.Gender
import com.example.core.user.model.Provider
import com.example.core.user.model.Role
import java.time.LocalDateTime
import java.util.UUID

data class MemberDetailQueryDto
constructor(
    val id: UUID,
    val email: String,
    val password: String,
    val role: Role,
    val provider: Provider?,
    val createdAt: LocalDateTime,
    val deletedAt: LocalDateTime?,
    val profile: String?,
    val memberInfoQueryDto: MemberInfoQueryDto?,
)

data class MemberInfoQueryDto
constructor(
    val gender: Gender?,
    val nickname: String?,
    val exerciseMonths: Int?,
    val tall: Double?,
    val weight: Double?,
    val skeletalMuscleMass: Double?,
    val age: Int?,
) {
    fun isNotNull(): Boolean = gender != null &&
        nickname != null &&
        tall != null &&
        weight != null &&
        age != null
}
