package com.sammydj.etsytool.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sammydj.etsytool.model.listing.ItemDimensionsUnit
import com.sammydj.etsytool.model.listing.ItemWeightUnit
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

    /**

    @ExperimentalSerializationApi
    @TypeConverter
    fun jsonToList(value: String) = Json.decodeFromString<List<String>>(value)

    @ExperimentalSerializationApi
    @TypeConverter
    fun listToJson(value: List<String>) = Json.encodeToString(value)

*/
    @TypeConverter
    fun toItemWeightUnit(value: String) = enumValueOf<ItemWeightUnit>(value)

    @TypeConverter
    fun fromItemWeightUnit(value: ItemWeightUnit) = value.name

    @TypeConverter
    fun toItemDimensionsUnit(value: String) = enumValueOf<ItemDimensionsUnit>(value)

    @TypeConverter
    fun fromItemDimensionsUnit(value: ItemDimensionsUnit) = value.name

    @TypeConverter
    fun listToJson2(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun arrayToList(value: Array<String>) =

    @TypeConverter
    fun(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun fromString(value: String?): ArrayList<String?>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}