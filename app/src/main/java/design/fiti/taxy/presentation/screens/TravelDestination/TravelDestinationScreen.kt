package design.fiti.taxy.presentation.screens.TravelDestination

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.maps.LocationSource
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import design.fiti.taxy.R
import design.fiti.taxy.presentation.screens.Login.CtaButton

@Composable
fun TravelDestinationScreen(
    navController: NavHostController,
    mapsViewModel: TravelDestinationViewModel
) {
    val state by mapsViewModel.state.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxHeight()) {
            Column(modifier = Modifier.padding(it)) {
                Surface(modifier = Modifier.weight(0.45f)) {
                    Box(modifier = Modifier.fillMaxHeight(0.7f)) {
                        val singapore = LatLng(
                            state.lastKnownLocation?.longitude ?: 1.35,
                            state.lastKnownLocation?.longitude ?: 103.87
                        )
                        val cameraPositionState = rememberCameraPositionState {
                            position = CameraPosition.fromLatLngZoom(singapore, 10f)
                        }
                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            cameraPositionState = cameraPositionState
                        ) {
                            Marker(
                                state = MarkerState(position = singapore),
                                title = "Singapore",
                                snippet = "Marker in Singapore"
                            )
                        }
//                    Image(
//                        contentScale= ContentScale.Fit,
//                        painter = painterResource(id = R.drawable.map), contentDescription = null)

                    }
                }

                Spacer(modifier = Modifier.weight(0.5f))
            }
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.fillMaxHeight(0.55f))
                InformaticsSection()

            }

        }
    }

}

@Preview
@Composable
fun InformaticsSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .fillMaxHeight()
            .padding(start = 24.dp, end = 24.dp, top = 24.dp)
    ) {
        Text(
            text = "Where would you like to go today?",
            style = TextStyle(
                fontSize = 20.37.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF07090D),
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFDEE3F1), shape = RoundedCornerShape(size = 16.dp))
                .padding(24.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.from_to),
                    contentDescription = stringResource(id = R.string.from_to_icon)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Box(contentAlignment = Alignment.Center) {
                    Column {
                        FromToChip()
                        Spacer(modifier = Modifier.height(8.dp))
                        FromToChip(label = "AirPort")
                    }
                    Row {
                        Spacer(modifier = Modifier.fillMaxWidth(0.4f))
                        Image(
                            painter = painterResource(R.drawable.to_icon),
                            contentDescription = stringResource(id = R.string.to_icon)
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.solar_calendar_broken),
                        contentDescription = stringResource(
                            id = R.string.select_date
                        )
                    )
                }
                Text(
                    text = "Today 8:00 pm",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
            }
            Text(
                text = "1 Passenger",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Right,
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        CtaButton(label = "Book a ticket", backColor = Color(0xFF07090D))
    }
}

@Preview
@Composable
fun FromToChip(label: String = "Home") {
    Box(
        modifier = Modifier
            .background(
                shape = RoundedCornerShape(CornerSize(12.dp)),
                color = MaterialTheme.colorScheme.background
            )
            .padding(10.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 8.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
    }
}