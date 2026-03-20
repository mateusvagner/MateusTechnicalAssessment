package com.mat.mateus_technical_assessment.domain

import com.mat.mateus_technical_assessment.data.dto.LoginRequest
import com.mat.mateus_technical_assessment.data.local.LocalStorage
import com.mat.mateus_technical_assessment.data.repository.LoginRepository

class LoginUseCase(
    private val loginRepository: LoginRepository,
    private val localStorage: LocalStorage
) {
    suspend fun invoke(userName: String, userPassword: String): Boolean {
        try {
            val loginResponse = loginRepository.login(
                loginRequest = LoginRequest(
                    userName = userName,
                    userPassword = userPassword
                )
            )

            // TODO save logic
            localStorage.saveCredentials()
            return true
        } catch (e: Exception) {
            return false
        }
    }
}