package oil.oing.nearby.price

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import oil.oing.nearby.presentation.MainActivity
import oil.oing.nearby.presentation.ui.theme.OilOingTheme

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            OilOingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    SplashScreen(navigateToScreen = ::navigateToMain)
                }
            }
        }
    }

    private fun navigateToMain() {
        startActivity(MainActivity.getIntent(this@SplashActivity))
        finish()
    }
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToScreen: () -> Unit) {
    LaunchedEffect(
        key1 = true,
        block = {
            delay(3000L)
            navigateToScreen()
        }
    )
    Box(
        modifier = modifier.fillMaxSize()
    )
}
