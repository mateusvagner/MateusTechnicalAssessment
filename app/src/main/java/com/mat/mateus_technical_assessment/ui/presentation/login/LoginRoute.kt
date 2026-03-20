package com.mat.mateus_technical_assessment.ui.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mat.mateus_technical_assessment.ui.theme.MateusTechnicalAssessmentTheme

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    LoginScreen(
        modifier = modifier,
        uiState = uiState,
        onUserNameChanged = viewModel::onUserNameChanged,
        onPasswordChanged =  viewModel::onPasswordChanged,
        onLoginPressed =  viewModel::onLoginPressed
    )

}

@Composable
private fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginPressed: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            placeholder = {
                Text("Type your name")
            },
            value = uiState.userName,
            onValueChange = onUserNameChanged,
            isError = !uiState.isUserNameValid
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            placeholder = {
                Text("Type your password")
            },
            value = uiState.userPassword,
            onValueChange = onPasswordChanged,
            isError = !uiState.isUserPasswordValid
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onLoginPressed
        ) {
            Text("Login!")
        }
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
            onPasswordChanged = {},
            onLoginPressed = {}
        )
    }
}