package design.fiti.taxy.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import design.fiti.taxy.presentation.screens.Login.LoginScreen
import design.fiti.taxy.presentation.screens.SignUp.SignUpScreen
import design.fiti.taxy.presentation.screens.TicketListings.TicketListingsScreen
import design.fiti.taxy.presentation.screens.TicketReceiptListing.TicketReceiptListingScreen
import design.fiti.taxy.presentation.screens.TravelDestination.TravelDestinationScreen
import design.fiti.taxy.presentation.screens.TravelDestination.TravelDestinationViewModel

@Composable
fun TaxyApp(mapsViewModel: TravelDestinationViewModel) {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            modifier = Modifier.padding(it),
            startDestination = NavRoutes.SignUp.name
        ) {
            composable(route = NavRoutes.Login.name) {
                LoginScreen(navController = navController)
            }
            composable(route = NavRoutes.TravelDestination.name) {
                TravelDestinationScreen(navController = navController, mapsViewModel = mapsViewModel)
            }
            composable(route = NavRoutes.SignUp.name) {
                SignUpScreen(navController = navController)
            }
            composable(route = NavRoutes.TicketListings.name) {
                TicketListingsScreen(navController = navController)
            }
            composable(route = NavRoutes.TicketReceiptListing.name) {
                TicketReceiptListingScreen(navController = navController)
            }
        }
    }
}

sealed class NavRoutes(val name: String) {
    object Login : NavRoutes(ScreenNames.LOGIN.name)
    object TravelDestination : NavRoutes(ScreenNames.TRAVELDESTINATION.name)
    object SignUp : NavRoutes(ScreenNames.SIGNUP.name)
    object TicketListings : NavRoutes(ScreenNames.TICKETLISTINGS.name)
    object TicketReceiptListing : NavRoutes(ScreenNames.TICKETRECEIPTLISTING.name)
}

enum class ScreenNames {
    LOGIN, TRAVELDESTINATION, SIGNUP, TICKETLISTINGS, TICKETRECEIPTLISTING
}