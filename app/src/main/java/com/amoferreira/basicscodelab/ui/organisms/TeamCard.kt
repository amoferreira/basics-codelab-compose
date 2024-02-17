package com.amoferreira.basicscodelab.ui.organisms

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amoferreira.basicscodelab.R
import com.amoferreira.basicscodelab.data.Team
import com.amoferreira.basicscodelab.ui.molecules.TeamCardHeader
import com.amoferreira.basicscodelab.ui.molecules.TeamMoreInfo

@Composable
fun TeamCard(
    modifier: Modifier = Modifier,
    team: Team,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Surface(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_shape)),
        border = BorderStroke(dimensionResource(id = R.dimen.card_border_stroke), color = MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = modifier.padding(dimensionResource(id = R.dimen.card_padding))
        ) {
            TeamCardHeader(
                image = team.symbol,
                title = team.name,
                iconButton = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                iconButtonClicked = { expanded = !expanded }
            )

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearEasing
                    ),
                    expandFrom = Alignment.Top
                ) + fadeIn(),
                exit = shrinkVertically(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearEasing
                    ),
                    shrinkTowards = Alignment.Top
                ) + fadeOut()
            ) {
                TeamMoreInfo(
                    modifier = Modifier.padding(top = 8.dp, start = 4.dp),
                    yearFoundation = team.foundationYear,
                    stadium = team.stadium,
                    city = team.city
                )
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TeamCardPreview() {
    TeamCard(
        team = Team(
            name = "FC Porto",
            foundationYear = stringResource(id = R.string.year_fcporto),
            city = stringResource(id = R.string.city_fcporto),
            symbol = R.drawable.img_fcporto,
            stadium = stringResource(id = R.string.stadium_fcporto)
        )
    )
}