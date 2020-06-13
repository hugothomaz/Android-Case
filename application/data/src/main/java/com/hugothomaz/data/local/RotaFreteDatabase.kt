package com.hugothomaz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hugothomaz.data.local.entity.FreightEntity

const val DB_NAME = "rotafrete.db"

@Database(entities = [FreightEntity::class], exportSchema = false, version = 1)
@TypeConverters(DateConverter::class)
abstract class RotaFreteDatabase : RoomDatabase(){

    abstract fun freightDao() : FreightDao
}