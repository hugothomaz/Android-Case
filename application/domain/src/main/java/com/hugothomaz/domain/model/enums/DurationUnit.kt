package com.hugothomaz.domain.model.enums

enum class DurationUnit(val durationUnit: String) {

    SECONDS("seconds");

    override fun toString(): String {
        return when(durationUnit.toUpperCase()){
            SECONDS.name.toUpperCase() -> "segundos"
            else -> ""
        }
    }

}
