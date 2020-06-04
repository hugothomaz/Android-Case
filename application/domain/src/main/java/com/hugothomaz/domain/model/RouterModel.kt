package com.hugothomaz.domain.model

import com.hugothomaz.domain.model.enums.FueldTypeEnum

data class RouterModel(
    val pointModelStart : PointModel,
    val pointModelEnd: PointModel,
    val axis : Int,
    val fuelTypeEnum : FueldTypeEnum,
    val fuelConsumption : Double,
    val fuelPrice : Double
)




