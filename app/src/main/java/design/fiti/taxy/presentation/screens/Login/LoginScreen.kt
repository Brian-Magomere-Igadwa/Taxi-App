package design.fiti.taxy.presentation.screens.Login

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {

}

@Preview
@Composable
fun AppFormInput(

) {
    var inputValue by remember {
        mutableStateOf("")
    }
    TextField(
        value = inputValue,
        label = { Text(text = "Email") },
        onValueChange = { inputValue = it })
}