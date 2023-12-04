package design.fiti.taxy.presentation.screens.Login

import androidx.lifecycle.ViewModel
import design.fiti.taxy.presentation.screens.SignUp.SignUpState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(LogInState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onLoginClicked() {
        verifyEmail()
        if (_uiState.value.password.isEmpty()) {
            _uiState.update {
                it.copy(
                    passwordError = "Password cannot be empty",
                    hasErrored = true
                )
            }
        } else {
            _uiState.update { it.copy(passwordError = "", hasErrored = false) }
        }
    }


    private fun verifyEmail() {
        if (_uiState.value.email.isEmpty()) {
            _uiState.update { it.copy(emailError = "Email cannot be empty", hasErrored = true) }
        } else {
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(_uiState.value.email).matches()) {
                _uiState.update {
                    it.copy(
                        emailError = "What an email! El Terrifico!",
                        hasErrored = false
                    )
                }
            } else {
                _uiState.update { it.copy(emailError = "Invalid email", hasErrored = true) }
            }
        }
    }

}