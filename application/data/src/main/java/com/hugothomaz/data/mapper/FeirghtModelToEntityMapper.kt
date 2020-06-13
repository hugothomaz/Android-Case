package com.hugothomaz.data.mapper

import com.hugothomaz.data.local.entity.FreightEntity
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel

class FeirghtModelToEntityMapper : IMapper<Pair<RouterModel, FreightModel>, FreightEntity> {

    override fun transform(pair: Pair<RouterModel, FreightModel>): FreightEntity {
        val routerMode = pair.first
        val freightMode = pair.second

        return FreightEntity(
            date = freightMode.date,
            distance = freightMode.distance,
            distanceUnit = freightMode.distanceUnit.distanceUnit,
            duration = freightMode.duration,
            durationUnit = freightMode.durationUnit.durationUnit,
            hasToll = freightMode.hasToll,
            tollCost = freightMode.tollCost,
            tollCount = freightMode.tollCount,
            tollMoneyUnit = freightMode.tollMoneyUnit,
            fuelUsed = freightMode.fuelUsed,
            fuelUseUnit = freightMode.fuelUseUnit.unit,
            fuelCost = freightMode.fuelCost,
            fuelMoneyUnit = freightMode.fuelMoneyUnit,
            totalCost = freightMode.totalCost,
            frigorificada = freightMode.typeOfCargoModel.frigorificada,
            perigosa = freightMode.typeOfCargoModel.perigosa,
            neogranel = freightMode.typeOfCargoModel.neogranel,
            granel = freightMode.typeOfCargoModel.granel,
            geral = freightMode.typeOfCargoModel.geral,
            fuelConsumption = routerMode.fuelConsumption,
            axis = routerMode.axis,
            fuelPrice = routerMode.fuelPrice
        )
    }

}