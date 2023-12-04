package design.fiti.taxy.presentation.screens.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import design.fiti.taxy.R
import design.fiti.taxy.presentation.navigation.ScreenNames
import design.fiti.taxy.presentation.screens.SignUp.SignUpViewModel

@Composable
fun LoginScreen(navController: NavHostController) {
    val viewModel: LoginViewModel = LoginViewModel()
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
            Spacer(Modifier.height(32.dp))
            AppFormInput(
                label = stringResource(id = R.string.email),
                inputValue = state.email,
                handleChange = { viewModel.onEmailChange(it) },
                error = if (state.hasErrored) state.emailError else ""
            )
            Spacer(Modifier.height(16.dp))
            AppFormInput(
                label = stringResource(id = R.string.password),
                inputValue = state.password,
                handleChange = {
                    viewModel.onPasswordChange(it)
                    viewModel.onLoginClicked()
                },
                error = if (state.hasErrored) state.passwordError else ""
            )
            Spacer(Modifier.height(32.dp))
            CtaButton(handleClick = {
                viewModel.onLoginClicked()
                if (!state.hasErrored) {
                    navController.navigate(ScreenNames.TRAVELDESTINATION.name)
                }
            })
        }
    }

}


@Preview
@Composable
fun AppLogo() {
    Text(
        text = stringResource(R.string.app_logo), style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xA19D9E9E),

            )
    )
}

@Preview
@Composable
fun AppFormInput(
    inputValue: String = "",
    label: String = "",
    handleChange: (String) -> Unit = {},
    error: String = ""
) {
    Column {
        TextField(
            value = inputValue,
            label = { Text(text = label) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            onValueChange = { handleChange(it) })
        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF810D35),
                )
            )
        }
    }

}