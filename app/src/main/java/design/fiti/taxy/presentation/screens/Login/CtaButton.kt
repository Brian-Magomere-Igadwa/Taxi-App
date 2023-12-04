package design.fiti.taxy.presentation.screens.Login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CtaButton(
    backColor: Color = MaterialTheme.colorScheme.primary,
    label: String = "Login",
    handleClick: () -> Unit = {}
) {
    Button(
        onClick = handleClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backColor
        ),
        shape = RoundedCornerShape(CornerSize(16.dp)),
        modifier = Modifier.fillMaxWidth(0.7f),
    ) {
        Text(text = label)
    }

}