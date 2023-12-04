package design.fiti.taxy.presentation.screens.SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import design.fiti.taxy.R
import design.fiti.taxy.presentation.navigation.ScreenNames
import design.fiti.taxy.presentation.screens.Login.AppFormInput
import design.fiti.taxy.presentation.screens.Login.AppLogo
import design.fiti.taxy.presentation.screens.Login.CtaButton

@Composable
fun SignUpScreen(navController: NavHostController) {
    val viewModel: SignUpViewModel = SignUpViewModel()
    val state by viewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(32.dp))
            AppLogo()
            Spacer(Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.business_trip_guy),
                contentDescription = stringResource(id = R.string.image_asset)
            )
            Text(
                text = "Book conviniently",
                style = TextStyle(
                    fontSize = 13.87.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xA19D9E9E),

                    )
            )
            Spacer(Modifier.height(32.dp))
            AppFormInput(
                label = stringResource(id = R.string.email),
                error = if (state.hasErrored) state.emailError else "",
                inputValue = state.email,
                handleChange = {
                    viewModel.onEmailChange(it)
                    viewModel.verifyInputs()
                })
            Spacer(Modifier.height(16.dp))
            AppFormInput(
                label = stringResource(R.string.password),
                error = if (state.hasErrored) state.passwordError else "",
                inputValue = state.password,
                handleChange = {
                    viewModel.onPasswordChange(it)
                    viewModel.verifyInputs()
                })
            Spacer(Modifier.height(16.dp))
            AppFormInput(
                label = stringResource(id = R.string.confirm_password),
                error = if (state.hasErrored) state.confirmPasswordError else "",
                inputValue = state.confirmPassword,
                handleChange = {
                    viewModel.onConfirmPasswordChange(it)
                    viewModel.verifyInputs()
                })
            Spacer(Modifier.height(32.dp))
            CtaButton(
                label = "Sign Up",
                handleClick = {
                    viewModel.onSignUpClicked()
                    if (!state.hasErrored) {
                        navController.navigate(ScreenNames.LOGIN.name)
                    }
                })
        }
    }
}