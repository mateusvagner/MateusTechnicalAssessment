package com.mat.mateus_technical_assessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mat.mateus_technical_assessment.data.local.impl.LocalStorageImpl
import com.mat.mateus_technical_assessment.data.repository.impl.LoginRepositoryImpl
import com.mat.mateus_technical_assessment.domain.LoginUseCase
import com.mat.mateus_technical_assessment.ui.presentation.login.LoginRoute
import com.mat.mateus_technical_assessment.ui.presentation.login.LoginViewModel
import com.mat.mateus_technical_assessment.ui.theme.MateusTechnicalAssessmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MateusTechnicalAssessmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val loginRepository = LoginRepositoryImpl()
                    val localStorage = LocalStorageImpl()
                    val loginUseCase = LoginUseCase(
                        loginRepository = loginRepository,
                        localStorage = localStorage
                    )

                    val loginViewModel = LoginViewModel(loginUseCase)

                    LoginRoute(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = loginViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $name!",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MateusTechnicalAssessmentTheme {
        Greeting(
            modifier = Modifier
                .fillMaxSize(),
            name = "Android"
        )
    }
}
