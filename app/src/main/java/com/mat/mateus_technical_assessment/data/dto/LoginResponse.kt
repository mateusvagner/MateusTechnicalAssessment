package com.mat.mateus_technical_assessment.data.dto

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)
