package com.hugothomaz.domain.model.enums

enum class DistanceUnitEnum(val distanceUnit : String) {

    METERS("meters");

    override fun toString() : String{
        return when(distanceUnit){
            METERS.name -> "Metros"
            else -> ""
        }
    }

}
