package com.hugothomaz.domain.model

import com.hugothomaz.domain.model.enums.DistanceUnitEnum
import com.hugothomaz.domain.model.enums.MoneyUnitEnum
import com.hugothomaz.domain.model.enums.VolumeUnitEnum
import java.util.*

data class FreightModel(
    val date : Date,
    val distance: Double,
    val distanceUnit: DistanceUnitEnum,
    val duration: Int,
    val durationUnit: DurationUnit,
    val hasToll: Boolean,
    val tollCount: Int,
    val tollCost: Double,
    val tollMoneyUnit: MoneyUnitEnum,
    val fuelUsed: Double,
    val volumeUnitEnum: VolumeUnitEnum,
    val fuelCost: Double,
    val fuelMoneyUnit: MoneyUnitEnum,
    val totalCost: Double
)