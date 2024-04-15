package com.example.check24tech.data.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.check24tech.utils.Constants
import java.math.BigDecimal


@Entity(tableName = Constants.TABLE_NAME)
data class SaleItemDto(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description: String? = null,
    var price: BigDecimal? = null,
    var image: Uri? = null
)


