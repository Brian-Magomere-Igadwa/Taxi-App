package design.fiti.taxy

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performKeyInput
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import design.fiti.taxy.presentation.navigation.ScreenNames
import design.fiti.taxy.presentation.screens.SignUp.SignUpScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SignUpInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUpSignUpScreen() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            SignUpScreen(navController = navController)
        }
    }

    @Test
    fun signUpScreen_signUpClicked_navigatesToLogin() {
        enterDummyUserDetails()
        composeTestRule.onNodeWithText("Sign Up").performClick()
        assert(navController.currentDestination?.route == ScreenNames.LOGIN.name)
    }

    fun enterDummyUserDetails() {
        composeTestRule.onNodeWithText("Email").performTextInput("alberteinstein@gmail.com")
        composeTestRule.onNodeWithText("Password").performTextInput("12345678")
        composeTestRule.onNodeWithText("Confirm Password").performTextInput("12345678")
    }


}