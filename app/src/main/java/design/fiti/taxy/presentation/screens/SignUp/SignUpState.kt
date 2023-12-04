package design.fiti.taxy.presentation.screens.SignUp

data class SignUpState(
    val email: String = "",
    val emailError: String = "",
    val password: String = "",
    val passwordError: String = "",
    val confirmPassword: String = "",
    val confirmPasswordError: String = "",
    val hasErrored: Boolean = true
)
