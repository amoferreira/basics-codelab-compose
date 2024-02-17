package com.amoferreira.basicscodelab.ui.atom

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.amoferreira.basicscodelab.R

@Composable
fun DescriptionText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Start,
        lineHeight = 20.sp,
    )
}

@Preview
@Composable
fun DescriptionTextPreview() {
    DescriptionText(text = stringResource(id = R.string.onboarding_screen_goal_description))
}