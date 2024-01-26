package com.example.api.trainer

import com.example.api.member.`in`.reponse.SuccessAuthenticationResponse
import com.example.api.member.`in`.request.SendAuthenticationNumberRequest
import com.example.api.member.`in`.request.SignUpFromEmailRequest
import com.example.api.member.`in`.request.VerifyAuthenticationNumberRequest
import com.example.api.member.`in`.request.toCommand
import com.example.api.response.ApiResponse
import com.example.core.user.application.`in`.EmailVerifyUseCase
import com.example.core.user.member.application.`in`.SignUpMemberUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/trainer")
class TrainerController(
    private val emailVerifyUseCase: EmailVerifyUseCase,
    private val signUpMemberUseCase: SignUpMemberUseCase,
) {
    @PostMapping("/email-verify")
    fun authenticateEmail(
        @RequestBody request: VerifyAuthenticationNumberRequest,
    ): ApiResponse<SuccessAuthenticationResponse> {
        val success = emailVerifyUseCase.verifyEmail(request.toCommand())
        val response = SuccessAuthenticationResponse(success)
        return ApiResponse(data = response)
    }

    @PostMapping("/send/email-verify")
    fun sendAuthenticationNumberEmail(
        @RequestBody
        request: SendAuthenticationNumberRequest,
    ): ApiResponse<Unit> {
        emailVerifyUseCase.sendVerifyEmail(request.toCommand())
        return ApiResponse(data = Unit)
    }

    @PostMapping("/sign-up/trainer")
    fun signUpTrainer(
        @RequestBody
        request: SignUpFromEmailRequest,
    ): ApiResponse<Unit> {
        signUpMemberUseCase.signUpMemberFromEmail(request.toCommand())
        return ApiResponse(data = Unit)
    }
}