package com.hugothomaz.domain.model.enums

enum class VolumeUnitEnum(val unit : String) {

    LITERS("liters");

    override fun toString(): String {
        return when(unit){
            LITERS.name -> "litros"
            else -> ""
        }
    }

}

