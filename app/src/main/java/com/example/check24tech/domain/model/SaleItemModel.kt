package com.example.check24tech.domain.model

import android.net.Uri
import java.math.BigDecimal

data class SaleItemModel(
    var id: Int,
    var title: String,
    var description: String? = null,
    var price: BigDecimal? = null,
    var image: Uri? = null
)
