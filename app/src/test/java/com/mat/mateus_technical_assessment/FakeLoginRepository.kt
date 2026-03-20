package com.mat.mateus_technical_assessment

import com.mat.mateus_technical_assessment.data.dto.LoginRequest
import com.mat.mateus_technical_assessment.data.dto.LoginResponse
import com.mat.mateus_technical_assessment.data.repository.LoginRepository

class FakeLoginRepository: LoginRepository {
    var loginError: String? = null

    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        if (loginError != null) {
            throw RuntimeException(loginError!!)
        }

        return LoginResponse(
            accessToken = "123",
            refreshToken = "123"
        )
    }
}