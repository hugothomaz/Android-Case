package com.hugothomaz.domain.model.enums

enum class MoneyUnitEnum(val unitOfMoney : String) {

    REAL("R$");

    override fun toString(): String {
        return when(unitOfMoney){
            REAL.name -> "R$"
            else -> ""
        }
    }

}
