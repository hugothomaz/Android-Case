package com.hugothomaz.domain.model.enums

enum class FueldTypeEnum(val type : String) {

    DIESEL("diesel");

    override fun toString(): String {
        return when(type){
            DIESEL.name -> "Diesel"
            else -> ""
        }
    }

}
