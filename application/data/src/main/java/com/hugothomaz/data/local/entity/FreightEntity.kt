package com.hugothomaz.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "freight")
data class FreightEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val axis : Int,
    val fuelConsumption : Double,
    val fuelPrice : Double,
    val date : Date,
    val distance: Int,
    val distanceUnit: String,
    val duration: Int,
    val durationUnit: String,
    val hasToll: Boolean,
    val tollCount: Int,
    val tollCost: Double,
    val tollMoneyUnit: String,
    val fuelUsed: Double,
    val fuelUseUnit: String,
    val fuelCost: Double,
    val fuelMoneyUnit: String,
    val totalCost: Double,
    val frigorificada: Double,
    val geral: Double,
    val granel: Double,
    val neogranel: Double,
    val perigosa: Double

)