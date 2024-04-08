package com.example.checkidenttask.presentation.new_item_screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberImagePainter
import com.example.checkidenttask.domain.model.SaleItem
import com.example.checkidenttask.presentation.destinations.ItemsScreenDestination
import com.example.reviewcodetechtask.R
import com.ramcosta.composedestinations.BuildConfig
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewItemScreen(
    navigator: DestinationsNavigator,
    saleItemId: Int = -1,
    viewModel: NewItemViewModel = koinViewModel()
) {
    var textTitle by remember { mutableStateOf("") }
    var textDescription by remember { mutableStateOf("") }
    var textPrice by remember { mutableStateOf("") }
    var editItem by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(key1 = true){
        if (saleItemId != -1){
            viewModel.getSaleItemById(id = saleItemId)

            viewModel.editSaleItem.collect { uiState ->
                editItem = true
                textTitle = uiState.saleItem?.title.toString()
                textDescription = uiState.saleItem?.description ?: "Without description"
                textPrice = (uiState.saleItem?.price ?: 0.0).toString()
            }
        }else editItem = false
    }


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
                    Text("Description")
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = textPrice,
                onValueChange = {
                    if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d{0,2}\$"))) {
                        textPrice = it
                    }
                },
                label = {
                    Text("Price")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Image(
            modifier = Modifier.size(100.dp)
                .clickable {
                    val permissionCheckResult =
                    ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                        cameraLauncher.launch(uri)
                    } else {
                        // Request a permission
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                           },
            painter = if (capturedImageUri.path?.isNotEmpty() == true){
                rememberImagePainter(capturedImageUri)
            } else{
                painterResource(id = R.drawable.ic_photo_camera)
                  },
            contentDescription = "photo",
        )
        Button(
            onClick = {
                if (editItem){
                    viewModel.updateSaleItem(
                        SaleItem(
                            id = saleItemId,
                            title = textTitle,
                            description = textDescription.takeUnless { it.isNullOrEmpty() } ?: "Without description",
                            price = textPrice.toDouble(),
                            image = capturedImageUri
                        )
                    )
                }else{
                    viewModel.insertSaleItem(
                        SaleItem(
                            title = textTitle,
                            description = textDescription.takeUnless { it.isNullOrEmpty() } ?: "Without description",
                            price = textPrice.toDouble(),
                            image = capturedImageUri
                        )
                    )
                }
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

fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName, /* prefix */
        ".jpg", /* suffix */
        externalCacheDir      /* directory */
    )
    return image
}

//@Preview
//@Composable
//fun SimpleComposablePreview() {
//   // NewItemScreen()
//}