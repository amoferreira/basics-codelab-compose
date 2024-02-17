package com.amoferreira.basicscodelab.ui.atom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.basicscodelab.R

@Composable
fun InfoRow(
    modifier: Modifier = Modifier,
    infoName: String,
    infoValue: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$infoName:",
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.info_value_spacing)))
        Text(
            text = infoValue,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Preview(widthDp = 320)
@Composable
fun InfoRowPreview() {
    InfoRow(infoName = "Stadium", infoValue = "Estádio do Dragão")
}