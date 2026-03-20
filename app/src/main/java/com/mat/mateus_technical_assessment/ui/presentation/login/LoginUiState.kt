package com.mat.mateus_technical_assessment.ui.presentation.login

data class LoginUiState(
    val userName: String = "",
    val userPassword: String = "",
    val isLoggingIn : Boolean = false,
    val isUserNameValid: Boolean = false,
    val isUserPasswordValid: Boolean = false
)
