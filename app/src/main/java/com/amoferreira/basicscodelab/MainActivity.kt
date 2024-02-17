package com.amoferreira.basicscodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.basicscodelab.data.Teams
import com.amoferreira.basicscodelab.ui.screens.OnboardingScreen
import com.amoferreira.basicscodelab.ui.screens.TeamsListScreen
import com.amoferreira.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabApp()
        }
    }
}

@Composable
fun BasicCodelabApp() {
    BasicsCodelabTheme {
        val context = LocalContext.current
        var shouldShowOnboardingScreen by rememberSaveable { mutableStateOf(true) }
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            if (shouldShowOnboardingScreen) OnboardingScreen {
                shouldShowOnboardingScreen = false
            }
            else TeamsListScreen(teams = Teams(context).portugueseTeamsList)
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun AppPreview() {
    BasicsCodelabTheme {
        BasicCodelabApp()
    }
}
