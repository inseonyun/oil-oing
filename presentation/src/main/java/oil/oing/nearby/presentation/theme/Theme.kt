@file:OptIn(ExperimentalComposeUiApi::class)

package oil.oing.nearby.presentation.theme

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId


private val LocalColors = compositionLocalOf<OilOingColors> {
    error("No colors provided!")
}

@Composable
fun OilOingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: OilOingColors = OilOingColors.defaultLightColors(),
    background: OilOingBackground = OilOingBackground.defaultBackground(darkTheme),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalBackgroundTheme provides background,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                window.statusBarColor = colors.primary.toArgb()
            }
        }

        Box(
            modifier = Modifier
                .background(background.color)
                .semantics { testTagsAsResourceId = true },
        ) {
            content()
        }
    }
}

object OilOingTheme {
    val colors: OilOingColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val background: OilOingBackground
        @Composable
        @ReadOnlyComposable
        get() = LocalBackgroundTheme.current
}
