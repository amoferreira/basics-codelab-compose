package com.amoferreira.basicscodelab.ui.atom

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.basicscodelab.R

@Composable
fun ElevatedLabelButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    ElevatedButton(
        modifier = modifier.height(dimensionResource(id = R.dimen.button_height)),
        onClick = onClick,
        colors = buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ElevatedLabelButtonNightModePreview() {
    ElevatedLabelButton(label = "Continue", onClick = {})
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ElevatedLabelButtonLightModePreview() {
    ElevatedLabelButton(label = "Continue", onClick = {})
}