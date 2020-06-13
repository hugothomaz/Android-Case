package com.hugothomaz.domain.model

data class RouterModel(
    val pointModelStart : PointModel ?= null,
    val pointModelEnd: PointModel ?= null,
    val axis : Int,
    val fuelConsumption : Double,
    val fuelPrice : Double
)




