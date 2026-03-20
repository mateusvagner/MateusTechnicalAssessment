package com.mat.mateus_technical_assessment.data.repository

import com.mat.mateus_technical_assessment.data.dto.LoginRequest
import com.mat.mateus_technical_assessment.data.dto.LoginResponse

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): LoginResponse
}