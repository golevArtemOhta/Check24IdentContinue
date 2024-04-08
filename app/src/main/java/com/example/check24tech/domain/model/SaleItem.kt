package com.example.checkidenttask.domain.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


@Entity(tableName = "items_table")
data class SaleItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description : String? = null,
    var price: Double? = null,
    var image: Uri? = null
)
