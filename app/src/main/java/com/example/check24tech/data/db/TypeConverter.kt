package com.example.check24tech.data.db

import android.net.Uri
import androidx.room.TypeConverter
import java.math.BigDecimal

class UriConverter {
    @TypeConverter
    fun fromString(value: String?): Uri? {
        return if (value == null) null else Uri.parse(value)
    }

    @TypeConverter
    fun toString(uri: Uri?): String? {
        return uri?.toString()
    }

    @TypeConverter
    fun bigDecimalToDouble(input: BigDecimal?): Double {
        return input?.toDouble() ?: 0.0
    }

    @TypeConverter
    fun stringToBigDecimal(input: Double?): BigDecimal {
        if (input == null) return BigDecimal.ZERO
        return BigDecimal.valueOf(input) ?: BigDecimal.ZERO
    }
}


