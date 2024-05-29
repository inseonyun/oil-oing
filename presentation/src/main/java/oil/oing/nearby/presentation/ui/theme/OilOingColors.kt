package oil.oing.nearby.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import oil.oing.nearby.presentation.R

@Immutable
data class OilOingColors(
    val primary: Color,
    val background: Color,
    val backgroundLight: Color,
    val backgroundDark: Color,
    val absoluteWhite: Color,
    val absoluteBlack: Color,
    val white00: Color,
    val white01: Color,
    val black00: Color,
    val black01: Color,
    val grey01: Color,
    val orange00: Color,
    val orange01: Color,
    val orange02: Color,
    val yellow00: Color,
    val yellow01: Color,
) {

    companion object {
        @Composable
        fun defaultLightColors(): OilOingColors = OilOingColors(
            primary = colorResource(id = R.color.colorPrimary),
            background = colorResource(id = R.color.background),
            backgroundLight = colorResource(id = R.color.background800),
            backgroundDark = colorResource(id = R.color.background900),
            absoluteWhite = colorResource(id = R.color.white_00),
            absoluteBlack = colorResource(id = R.color.black_00),
            white00 = colorResource(id = R.color.white_00),
            white01 = colorResource(id = R.color.white_01),
            black00 = colorResource(id = R.color.black_00),
            black01 = colorResource(id = R.color.black_01),
            grey01 = colorResource(id = R.color.grey_01),
            orange00 = colorResource(id = R.color.orange_00),
            orange01 = colorResource(id = R.color.orange_01),
            orange02 = colorResource(id = R.color.orange_02),
            yellow00 = colorResource(id = R.color.yellow_00),
            yellow01 = colorResource(id = R.color.yellow_01),
        )
    }
}
