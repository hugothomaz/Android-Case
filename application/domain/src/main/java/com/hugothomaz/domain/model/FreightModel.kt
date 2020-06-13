package com.hugothomaz.domain.model

import com.hugothomaz.domain.extensions.localDateHourString
import com.hugothomaz.domain.extensions.toMoney
import com.hugothomaz.domain.model.enums.DistanceUnitEnum
import com.hugothomaz.domain.model.enums.DurationUnit
import com.hugothomaz.domain.model.enums.VolumeUnitEnum
import java.util.*

data class FreightModel(
    val date : Date,
    val distance: Int,
    val axis : Int,
    val fuelConsumption : Double,
    val fuelPrice : Double,
    val distanceUnit: DistanceUnitEnum,
    val duration: Int,
    val durationUnit: DurationUnit,
    val hasToll: Boolean,
    val tollCount: Int,
    val tollCost: Double,
    val tollMoneyUnit: String,
    val fuelUsed: Double,
    val fuelUseUnit: VolumeUnitEnum,
    val fuelCost: Double,
    val fuelMoneyUnit: String,
    val totalCost: Double,
    val typeOfCargoModel : TypeOfCargoModel
){

    fun getDateToString() : String {
        return date.localDateHourString()
    }

    fun getFuelPriceMoney() : String {
        return fuelPrice.toMoney()
    }

    fun getFuelConsumptionToVolume() : String{
        return fuelConsumption.toString().plus(" ${fuelUseUnit.toString()}")
    }

    fun getFuelUsedToVolume() : String {
        return fuelUsed.toString().plus(" ${fuelUseUnit.toString()}")
    }

    fun getFuelCostToMoney() : String {
        return fuelCost.toMoney()
    }

    fun getTollCostMoney() : String{
        return tollCost.toMoney()
    }

    fun getDistancia() : String {
        return distance.toString().plus(" ${distanceUnit.toString()}")
    }

    fun getFrigorificadaToMoney() : String {
        return typeOfCargoModel.frigorificada.toMoney()
    }

    fun getGeralToMoney() : String {
        return typeOfCargoModel.geral.toMoney()
    }

    fun getGranelToMoney() : String {
        return typeOfCargoModel.granel.toMoney()
    }

    fun getNeogranelToMoney() : String {
        return typeOfCargoModel.neogranel.toMoney()
    }

    fun getPerigosaToMoney() : String {
        return typeOfCargoModel.perigosa.toMoney()
    }

    fun getTotalCostToMoney() : String {
        return totalCost.toMoney()
    }


}