package com.example.quotes_app.data.db

import androidx.room.TypeConverter


class Converters {

    @TypeConverter
    fun fromListToString(tags: List<String>?): String {
        return tags?.joinToString(",") ?: ""
    }

    @TypeConverter
    fun fromStringToList(tags: String?): List<String> {
        return tags?.split(",") ?: emptyList()
    }
}