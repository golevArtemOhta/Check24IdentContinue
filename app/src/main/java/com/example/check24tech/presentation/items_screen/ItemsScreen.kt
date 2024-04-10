package com.example.check24tech.presentation.items_screen

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberImagePainter
import com.example.check24tech.presentation.destinations.NewItemScreenDestination
import com.example.reviewcodetechtask.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun ItemsScreen(navigator: DestinationsNavigator, viewModel: ItemsViewModel = koinViewModel()){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {

        viewModel.saleItemsList.collectAsStateWithLifecycle().value?.let { uiState ->
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(uiState.saleItemsList) { saleItem ->
                    Item(
                        title = saleItem.title,
                        description = saleItem.description ?: stringResource(id = R.string.without_description),
                        price = saleItem.price ?: 0.0,
                        image = saleItem.image,
                        clickByItem = {
                            navigator.navigate(NewItemScreenDestination(saleItemId = saleItem.id))
                        }
                    )
                }

            }
        }

        Button(onClick = {
            navigator.navigate(NewItemScreenDestination())
                         },
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier
                .padding(16.dp)
                .size(60.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp)) {
            Image(painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = stringResource(id = R.string.add_item))
        }
        Spacer(
            Modifier
                .height(20.dp)
        )
    }
}

@Composable
fun Item(
    title: String,
    description: String? = null,
    price: Double? = 0.0,
    image: Uri? = null,
    clickByItem: () -> Unit
){
    Card(
        modifier = Modifier
            .clickable { clickByItem.invoke() }
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        )
    ){
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    painter = if (image != null){
                        rememberImagePainter(image)
                    } else{
                        painterResource(id = R.drawable.ic_photo_camera)
                    },
                    contentDescription = stringResource(id = R.string.photo_example)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically), text = "$title",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Text(
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically), text = "$description",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight())
            Column(modifier = Modifier
                .background(Color.Blue)
                .width(70.dp)
                .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "$price €", color = Color.White)
            }
        }
    }
}
