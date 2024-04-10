package com.example.check24tech.domain.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.check24tech.utils.Constants


@Entity(tableName = Constants.TABLE_NAME)
data class SaleItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description : String? = null,
    var price: Double? = null,
    var image: Uri? = null
)


