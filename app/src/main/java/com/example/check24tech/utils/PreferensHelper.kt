package com.example.check24tech.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.check24tech.utils.Constants.FIRST_ITEM_ADD_KEY
import com.example.check24tech.utils.Constants.PREFS_NAME

object PreferensHelper {

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun isFirstItemAdded(context: Context): Boolean {
        return getPreferences(context).getBoolean(FIRST_ITEM_ADD_KEY, false)
    }

    fun setFirstItemAdded(context: Context, isAdded: Boolean) {
        getPreferences(context).edit().putBoolean(FIRST_ITEM_ADD_KEY, isAdded).apply()
    }
}