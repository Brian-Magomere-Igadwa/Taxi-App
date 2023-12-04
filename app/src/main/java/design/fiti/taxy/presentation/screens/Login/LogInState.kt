package design.fiti.taxy.presentation.screens.Login

data class LogInState(
    val email: String = "",
    val emailError: String = "",
    val password: String = "",
    val passwordError: String = "",
    val hasErrored: Boolean = true
)
