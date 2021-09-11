package com.sammydj.etsytool.converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun jsonToList(value: String) = Json.decodeFromString<List<String>>(value)

    @TypeConverter
    fun listToJson(value: List<String>) = Json.encodeToString(value)
}