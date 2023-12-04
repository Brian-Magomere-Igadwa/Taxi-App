package design.fiti.taxy.presentation.screens.SignUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _uiState.update { it.copy(confirmPassword = confirmPassword) }
    }

    fun onSignUpClicked() {
        verifyInputs()

    }

    fun verifyInputs() {
        verifyEmail()
        verifyPasswordMatch()
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

    private fun verifyPasswordMatch() {
        if (_uiState.value.password != _uiState.value.confirmPassword) {
            _uiState.update {
                it.copy(
                    passwordError = "Passwords do not match",
                    confirmPasswordError = "Passwords do not match",
                    hasErrored = true
                )
            }
        } else {
            if (_uiState.value.password.isEmpty()) {
                _uiState.update {
                    it.copy(
                        passwordError = "Password cannot be empty",
                        confirmPasswordError = "Password cannot be empty",
                        hasErrored = true
                    )
                }
            } else
                _uiState.update {
                    it.copy(
                        passwordError = "What a password! El Terrifico!",
                        confirmPasswordError = "What a password! El Terrifico!",
                        hasErrored = false
                    )
                }
        }
    }
}