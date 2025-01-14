package com.example.`in`.api.member.response

import com.example.core.user.dto.MemberDetailQueryDto
import com.example.core.user.dto.MemberInfoQueryDto
import com.example.core.user.model.Gender
import com.example.core.user.model.Role

data class MemberDetailResponse(
    val profile: String?,
    val role: Role,
    val memberInfoResponse: MemberInfoResponse?,
) {
    companion object {
        fun from(dto: MemberDetailQueryDto): MemberDetailResponse = dto
            .memberInfoQueryDto
            ?.let {
                if (it.isNotNull()) {
                    MemberDetailResponse(
                        profile = dto.profile,
                        role = dto.role,
                        memberInfoResponse = MemberInfoResponse(
                            nickname = it.nickname!!,
                            tall = it.tall!!,
                            weight = it.weight!!,
                            skeletalMuscleMass = it.skeletalMuscleMass,
                            gender = it.gender!!,
                            age = it.age!!,
                            exerciseMonths = it.exerciseMonths!!,
                        ),
                    )
                } else {
                    MemberDetailResponse(
                        profile = dto.profile,
                        role = dto.role,
                        memberInfoResponse = null,
                    )
                }
            } ?: MemberDetailResponse(
            profile = dto.profile,
            role = dto.role,
            memberInfoResponse = null,
        )
    }
}

data class MemberInfoResponse(
    val nickname: String,
    val tall: Double,
    val weight: Double,
    val skeletalMuscleMass: Double?,
    val gender: Gender,
    val age: Int,
    val exerciseMonths: Int,
) {
    companion object {
        fun from(query: MemberInfoQueryDto): MemberInfoResponse = MemberInfoResponse(
            nickname = query.nickname!!,
            tall = query.tall!!,
            weight = query.weight!!,
            skeletalMuscleMass = query.skeletalMuscleMass,
            gender = query.gender!!,
            age = query.age!!,
            exerciseMonths = query.exerciseMonths!!,
        )
    }
}
