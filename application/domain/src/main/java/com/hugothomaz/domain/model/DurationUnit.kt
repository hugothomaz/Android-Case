package com.hugothomaz.domain.model

enum class DurationUnit(val durationUnit: String) {

    SECONDS("seconds");

    override fun toString(): String {
        return when(durationUnit){
            SECONDS.name -> "segundos"
            else -> ""
        }
    }

}
