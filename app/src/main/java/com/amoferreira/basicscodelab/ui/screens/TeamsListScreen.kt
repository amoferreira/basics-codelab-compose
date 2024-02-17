package com.amoferreira.basicscodelab.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.basicscodelab.R
import com.amoferreira.basicscodelab.data.Team
import com.amoferreira.basicscodelab.ui.organisms.TeamCard

@Composable
fun TeamsListScreen(
    modifier: Modifier = Modifier,
    teams: List<Team>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.list_screen_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.list_items_spacing))
    ) {
        items(items = teams) { team ->
            TeamCard(team = team)
        }
    }
}

@Preview
@Composable
fun TeamsListScreenPreview() {
    TeamsListScreen(
        teams = listOf(
            Team(
            name = stringResource(R.string.name_moreirensefc),
            foundationYear = stringResource(R.string.year_moreirensefc),
            city = stringResource(R.string.city_moreirensefc),
            stadium = stringResource(R.string.stadium_moreirensefc),
            symbol = R.drawable.img_moreirensefc
            ),
            Team(
                name = stringResource(R.string.name_fcarouca),
                foundationYear = stringResource(R.string.year_fcarouca),
                city = stringResource(R.string.city_fcarouca),
                stadium = stringResource(R.string.stadium_fcarouca),
                symbol = R.drawable.img_fcarouca
            )
        )
    )
}