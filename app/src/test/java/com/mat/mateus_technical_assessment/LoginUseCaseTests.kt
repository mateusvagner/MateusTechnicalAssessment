package com.mat.mateus_technical_assessment

import com.mat.mateus_technical_assessment.domain.LoginUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class LoginUseCaseTests {

    lateinit var repository: FakeLoginRepository
    lateinit var localStorage: FakeLocalStorage

    @Before
    fun setup() {
        repository = FakeLoginRepository()
        localStorage = FakeLocalStorage()
    }
    @Test
    fun `test login success`() = runTest {
        // Arrange
        val loginUseCase = LoginUseCase(
            loginRepository = repository,
            localStorage = localStorage
        )

        // Act
        val isSuccess = loginUseCase.invoke("mateus", "pass")


        // Assert


    }

}