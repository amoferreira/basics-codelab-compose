package com.amoferreira.basicscodelab.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amoferreira.basicscodelab.R
import com.amoferreira.basicscodelab.ui.atom.InfoRow

@Composable
fun TeamMoreInfo(
    modifier: Modifier = Modifier,
    yearFoundation: String,
    stadium: String,
    city: String
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        InfoRow(infoName = stringResource(id = R.string.city_info), infoValue = city)
        InfoRow(infoName = stringResource(id = R.string.year_info), infoValue = yearFoundation)
        InfoRow(infoName = stringResource(id = R.string.stadium_info), infoValue = stadium)
    }
}

@Preview
@Composable
fun TeamMoreInfoPreview() {
        TeamMoreInfo(
            yearFoundation = stringResource(id = R.string.year_moreirensefc),
            city = stringResource(id = R.string.city_moreirensefc),
            stadium = stringResource(id = R.string.stadium_moreirensefc)
        )
}