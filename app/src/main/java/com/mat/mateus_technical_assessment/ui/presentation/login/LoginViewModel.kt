package com.mat.mateus_technical_assessment.ui.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mat.mateus_technical_assessment.domain.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()


    fun onUserNameChanged(userName: String) {
        _uiState.update {
            it.copy(
                userName = userName,
                isUserNameValid = userName.isNotEmpty(),
            )
        }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(
                userPassword = password,
                isUserPasswordValid = password.isNotEmpty(),
            )
        }
    }

    fun onLoginPressed() {
        val userName = _uiState.value.userName
        val password = _uiState.value.userPassword

        viewModelScope.launch {
            loginUseCase.invoke(userName, password)
        }

       viewModelScope.launch {
           loginUseCase.invoke(
               userName, password
           )
       }
    }
}
