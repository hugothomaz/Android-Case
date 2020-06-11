package com.hugothomaz.data.local

import androidx.room.TypeConverter
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss")

    @TypeConverter
    @JvmStatic
    fun dateStringToDate(dateString: String): Date? {
        return try {
            simpleDateFormat.parse(dateString)
        }catch (e : ParseException){
            e.printStackTrace()
            return null
        }
    }

    @TypeConverter
    @JvmStatic
    fun dateToDateString(date: Date): String? {
        return try {
            simpleDateFormat.format(date)
        }catch (e : Exception){
            e.printStackTrace()
            return null
        }
    }

}