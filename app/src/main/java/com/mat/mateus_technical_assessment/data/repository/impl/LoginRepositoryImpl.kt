package com.mat.mateus_technical_assessment.data.repository.impl

import com.mat.mateus_technical_assessment.data.dto.LoginRequest
import com.mat.mateus_technical_assessment.data.dto.LoginResponse
import com.mat.mateus_technical_assessment.data.repository.LoginRepository

class LoginRepositoryImpl: LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return LoginResponse(
            accessToken = "123",
            refreshToken = "123"
        )
    }
}