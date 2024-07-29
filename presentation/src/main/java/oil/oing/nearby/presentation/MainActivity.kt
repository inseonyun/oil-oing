package oil.oing.nearby.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.NaverMap
import dagger.hilt.android.AndroidEntryPoint
import oil.oing.nearby.presentation.theme.OilOingTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OilOingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = OilOingTheme.background.color) {
                    MainScreen()
                }
            }
        }
    }

    companion object {
        fun getIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MainScreen() {
    var mapProperties by remember {
        mutableStateOf(
            MapProperties(maxZoom = 17.0, minZoom = 10.0)
        )
    }
    var mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(isLocationButtonEnabled = false)
        )
    }
    Box(Modifier.fillMaxSize()) {
        NaverMap(properties = mapProperties, uiSettings = mapUiSettings)
        Column {
            Button(onClick = {
                mapProperties = mapProperties.copy(
                    isBuildingLayerGroupEnabled = !mapProperties.isBuildingLayerGroupEnabled
                )
            }) {
                Text(text = "Toggle isBuildingLayerGroupEnabled")
            }
            Button(onClick = {
                mapUiSettings = mapUiSettings.copy(
                    isLocationButtonEnabled = !mapUiSettings.isLocationButtonEnabled
                )
            }) {
                Text(text = "Toggle isLocationButtonEnabled")
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview(
) {
    MainScreen()
}

