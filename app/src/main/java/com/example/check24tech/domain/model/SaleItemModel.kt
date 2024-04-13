package com.example.check24tech.domain.model

import android.net.Uri

data class SaleItemModel(
    var id: Int,
    var title: String,
    var description: String? = null,
    var price: Double? = null,
    var image: Uri? = null
)
