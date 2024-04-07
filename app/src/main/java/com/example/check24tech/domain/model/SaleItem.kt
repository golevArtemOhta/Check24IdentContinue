package com.example.checkidenttask.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items_table")
data class SaleItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var description : String? = null,
    var price: Double? = null,
    var image: Int? = null
)
