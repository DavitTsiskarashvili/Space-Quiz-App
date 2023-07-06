package com.example.corecommon.data.local.entity

import androidx.room.TypeConverter

class ListStringConverter {
    @TypeConverter
    fun fromString(value: String?): List<String> {
        return value?.split(";") ?: emptyList()
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(";")
    }
}