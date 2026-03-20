package com.mat.mateus_technical_assessment.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mat.mateus_technical_assessment.ui.theme.MateusTechnicalAssessmentTheme

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {

}

@Composable
private fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = uiState.userName,
            onValueChange = {

            },
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = uiState.userPassword,
            onValueChange = {

            },
        )

        Spacer(modifier = Modifier.height(24.dp))

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    MateusTechnicalAssessmentTheme {
        LoginScreen(
            uiState = LoginUiState(
                userName = "mateus",
                userPassword = "123",
                isLoggingIn = false,
                isUserNameValid = true,
            ),
            onUserNameChanged = {},
            onPasswordChanged = {}
        )
    }
}