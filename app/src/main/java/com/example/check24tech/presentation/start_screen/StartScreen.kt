package com.example.check24tech.presentation.start_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.check24tech.presentation.destinations.ItemsScreenDestination
import com.example.check24tech.utils.PreferensHelper
import com.example.reviewcodetechtask.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun StartScreen(navigator: DestinationsNavigator) {
    val context = LocalContext.current
    val isFirstItemAdded = PreferensHelper.isFirstItemAdded(context = context)
    if (isFirstItemAdded) {
        navigator.navigate(ItemsScreenDestination)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(id = R.drawable.check24_logo),
            contentDescription = stringResource(
                id = R.string.logo_check24
            )
        )
        Button(
            onClick = { navigator.navigate(ItemsScreenDestination) },
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = stringResource(id = R.string.start))
        }
    }
}