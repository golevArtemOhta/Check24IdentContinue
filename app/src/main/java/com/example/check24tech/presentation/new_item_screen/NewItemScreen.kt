package com.example.check24tech.presentation.new_item_screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.compose.rememberImagePainter
import com.example.check24tech.data.model.SaleItemDto
import com.example.check24tech.presentation.destinations.ItemsScreenDestination
import com.example.check24tech.utils.PreferensHelper
import com.example.reviewcodetechtask.R
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
    var textPrice by remember { mutableStateOf("0.0") }
    var editItem by remember { mutableStateOf(false) }
    var capturedImageUri by remember { mutableStateOf<Uri>(Uri.EMPTY) }

    val state = rememberScrollState()

    val context = LocalContext.current

    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
            val title = viewModel.title.value
            val description = viewModel.description.value
            val price = viewModel.price.value
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, R.string.permission_granted, Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, R.string.permission_denied, Toast.LENGTH_SHORT).show()
        }
    }




    LaunchedEffect(key1 = true) {
        if (saleItemId != -1) {
            viewModel.initId(id = saleItemId).collect{saleItem ->
                editItem = true
                textTitle = saleItem?.title.toString()
                textDescription = saleItem?.description ?: context.resources.getString(R.string.without_description)
                textPrice = (saleItem?.price ?: 0.0).toString()
                capturedImageUri = saleItem?.image ?: context.getResourceUri(R.drawable.ic_photo_camera)
            }
        } else editItem = false
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state),
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
                    Text(text = stringResource(id = R.string.title))
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = textDescription,
                onValueChange = {
                    textDescription = it
                },
                label = {
                    Text(text = stringResource(id = R.string.description))
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
                    Text(text = stringResource(id = R.string.price))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Image(
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    val permissionCheckResult =
                        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                        cameraLauncher.launch(uri)
                        viewModel.putEnteredData()
                    } else {
                        // Request a permission
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                },
            painter = if (capturedImageUri.path?.isNotEmpty() == true) {
                rememberImagePainter(capturedImageUri)
            } else {
                painterResource(id = R.drawable.ic_photo_camera)
            },
            contentDescription = stringResource(id = R.string.photo),
        )
        Button(
            onClick = {
                if (editItem) {
                    viewModel.updateSaleItem(
                        SaleItemDto(
                            id = saleItemId,
                            title = textTitle,
                            description = textDescription.takeUnless { it.isNullOrEmpty() }
                                ?: context.resources.getString(R.string.without_description),
                            price = if (textPrice.isNotBlank()) textPrice.toDouble() else 0.0,
                            image = capturedImageUri
                        )
                    )
                } else {
                    val isFirstItemAdded = PreferensHelper.isFirstItemAdded(context = context)
                    if (!isFirstItemAdded){
                        PreferensHelper.setFirstItemAdded(context = context, true)
                    }
                    viewModel.insertSaleItem(
                        SaleItemDto(
                            title = textTitle,
                            description = textDescription.takeUnless { it.isNullOrEmpty() }
                                ?: context.resources.getString(R.string.without_description),
                            price = if (textPrice.isNotBlank()) textPrice.toDouble() else 0.0,
                            image = if (capturedImageUri.path?.isNotEmpty() == true){
                                capturedImageUri
                            } else{
                                context.getResourceUri(R.drawable.ic_photo_camera)
                            }
                        )
                    )
                }
                navigator.navigate(ItemsScreenDestination)
            },
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = stringResource(id = R.string.save))
        }
    }


}

fun createFileForPhoto(context: Context): Uri{
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )
    return uri
}

fun Context.createImageFile(): File {
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName, /* prefix */
        ".jpg", /* suffix */
        externalCacheDir      /* directory */
    )
    return image
}

fun Context.getResourceUri(@DrawableRes resId: Int): Uri {
    return Uri.parse("android.resource://$packageName/$resId")
}
