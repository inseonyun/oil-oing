package oil.oing.nearby.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import oil.oing.nearby.presentation.R

val LocalBackgroundTheme: ProvidableCompositionLocal<OilOingBackground> =
    staticCompositionLocalOf { OilOingBackground() }

data class OilOingBackground(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified,
) {
    companion object {
        @Composable
        fun defaultBackground(darkTheme: Boolean): OilOingBackground {
            return if (darkTheme) {
                OilOingBackground(
                    color = colorResource(id = R.color.background),
                    tonalElevation = 0.dp,
                )
            } else {
                OilOingBackground(
                    color = colorResource(id = R.color.background),
                    tonalElevation = 0.dp,
                )
            }
        }
    }
}
