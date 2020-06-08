package com.hugothomaz.domain.model

data class RouterModel(
    val pointModelStart : PointModel,
    val pointModelEnd: PointModel,
    val axis : Int,
    val fuelConsumption : Double,
    val fuelPrice : Double
)




