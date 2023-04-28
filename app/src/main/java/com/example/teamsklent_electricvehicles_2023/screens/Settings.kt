package com.example.teamsklent_electricvehicles_2023.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamsklent_electricvehicles_2023.R


@Preview
@Composable
fun Settings() {
    Column {
        Row {
            IconButton(
                onClick = {/*TODO*/ }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.account_edit),
                    contentDescription = "Edit Account"
                )
            }
        }
        Row {
            Card(
                shape = MaterialTheme.shapes.small
            ) {
                Text(
                    text = "Fleets",
                    modifier = Modifier.absolutePadding(10.dp, 0.dp, 0.dp, 0.dp),
                    fontSize = 20.sp
                )
                Row {
                    Text(
                        text = "Commercial Mode",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    RadioButton(
                        selected = false,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { /*TODO Turn on commercial mode*/ }
                    )
                }
            }
        }

    }
}