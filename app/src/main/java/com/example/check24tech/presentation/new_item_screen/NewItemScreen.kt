package com.example.checkidenttask.presentation.new_item_screen

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checkidenttask.domain.model.SaleItem
import com.example.checkidenttask.presentation.destinations.ItemsScreenDestination
import com.example.checkidenttask.presentation.destinations.NewItemScreenDestination
import com.example.checkidenttask.presentation.items_screen.ItemsScreen
import com.example.reviewcodetechtask.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewItemScreen(navigator: DestinationsNavigator, viewModel: NewItemViewModel = koinViewModel()) {
    var textTitle by remember { mutableStateOf("") }
    var textDescription by remember { mutableStateOf("") }
    var textPrice by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            OutlinedTextField(
                value = textTitle,
                onValueChange = {
                    textTitle = it
                },
                label = {
                    Text("Title")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = textDescription,
                onValueChange = {
                    textDescription = it
                },
                label = {
                    Text("Price")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = textPrice,
                onValueChange = {
                    textPrice = it
                },
                label = {
                    Text("Description")
                }
            )
        }

        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.ic_photo_camera),
            contentDescription = "photo"
        )
        Button(
            onClick = {
                viewModel.insertSaleItem(
                    SaleItem(
                        title = textTitle,
                        description = textDescription,
                        price = textPrice.toDouble()
                    )
                )
                navigator.navigate(ItemsScreenDestination)
            },
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = "SAVE")
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(label: String, textValue: String = "text") {
    var textTitle by remember { mutableStateOf("text") }
    OutlinedTextField(
        value = textValue,
        onValueChange = {
            var tetextValue = it
        },
        label = {
            Text("Label")
        }
    )
}

//@Preview
//@Composable
//fun SimpleComposablePreview() {
//   // NewItemScreen()
//}