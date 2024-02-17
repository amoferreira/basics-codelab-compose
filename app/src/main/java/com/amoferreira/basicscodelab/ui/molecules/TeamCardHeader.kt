package com.amoferreira.basicscodelab.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.amoferreira.basicscodelab.R

@Composable
fun TeamCardHeader(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    iconButton: ImageVector,
    iconButtonClicked: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Representation of $title",
                modifier = Modifier.size(dimensionResource(id = R.dimen.team_image_size))
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.team_image_name_spacing)))
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        IconButton(onClick = iconButtonClicked) {
            Icon(
                imageVector = iconButton,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun TeamCardHeaderPreview() {
    TeamCardHeader(
        image = R.drawable.img_fcporto,
        title = "FC Porto",
        iconButton = Icons.Filled.ExpandMore,
        iconButtonClicked = {}
    )
}