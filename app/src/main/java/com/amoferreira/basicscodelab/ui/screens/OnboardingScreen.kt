package com.amoferreira.basicscodelab.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.basicscodelab.R
import com.amoferreira.basicscodelab.ui.atom.DescriptionText
import com.amoferreira.basicscodelab.ui.atom.ElevatedLabelButton
import com.amoferreira.basicscodelab.ui.atom.LabelButton

@Composable
fun OnboardingScreen(onClickContinueAction: () -> Unit) {
    var shouldShowMoreInfo by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.onboarding_screen_vertical_padding),
                horizontal = dimensionResource(id = R.dimen.onboarding_screen_horizontal_padding)
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.onboarding_screen_title),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.onboarding_screen_title_text_spacing)))
            DescriptionText(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.onboarding_screen_goal_description)
            )
            LabelButton(
                label = if(shouldShowMoreInfo) stringResource(id = R.string.show_less_btn)
                else stringResource(id = R.string.show_more_btn)
            ) {
                shouldShowMoreInfo = !shouldShowMoreInfo
            }
            if(shouldShowMoreInfo) {
                DescriptionText(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.onboarding_screen_theme_description)
                )
            }
        }

        ElevatedLabelButton(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.continue_btn),
            onClick = onClickContinueAction
        )
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen {}
}