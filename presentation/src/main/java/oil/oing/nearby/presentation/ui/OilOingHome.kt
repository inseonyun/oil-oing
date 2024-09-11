package oil.oing.nearby.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.LocationTrackingMode
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberFusedLocationSource
import oil.oing.nearby.presentation.theme.OilOingTheme

@Composable
fun OilOingHome() {
    OilOingTheme {
        HomeScreen()
    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun HomeScreen() {
    val mapProperties by remember {
        mutableStateOf(
            MapProperties(maxZoom = 17.0, minZoom = 10.0, locationTrackingMode = LocationTrackingMode.Follow)
        )
    }
    val mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(isZoomControlEnabled = true, isLocationButtonEnabled = true)
        )
    }

    Box(Modifier.fillMaxSize()) {
        NaverMap(
            locationSource = rememberFusedLocationSource(),
            properties = mapProperties,
            uiSettings = mapUiSettings,
        )
    }
}
