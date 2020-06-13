package com.hugothomaz.data.mapper

import com.hugothomaz.data.local.entity.FreightEntity
import com.hugothomaz.domain.model.enums.DurationUnit
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.TypeOfCargoModel
import com.hugothomaz.domain.model.enums.DistanceUnitEnum
import com.hugothomaz.domain.model.enums.VolumeUnitEnum

class FeirghtEntityToModelMapper : IMapper<FreightEntity, FreightModel> {

    override fun transform(entity: FreightEntity): FreightModel {
        return FreightModel(
            id = entity.id,
            date = entity.date,
            distance = entity.distance,
            distanceUnit = DistanceUnitEnum.valueOf(entity.distanceUnit.toUpperCase()),
            duration = entity.duration,
            durationUnit = DurationUnit.valueOf(entity.durationUnit.toUpperCase()),
            hasToll = entity.hasToll,
            tollCost = entity.tollCost,
            tollCount = entity.tollCount,
            tollMoneyUnit = entity.tollMoneyUnit,
            fuelUsed = entity.fuelUsed,
            fuelUseUnit = VolumeUnitEnum.valueOf(entity.fuelUseUnit.toUpperCase()),
            fuelCost = entity.fuelCost,
            fuelMoneyUnit = entity.tollMoneyUnit,
            totalCost = entity.totalCost,
            typeOfCargoModel = TypeOfCargoModel(
                frigorificada = entity.frigorificada,
                perigosa = entity.perigosa,
                neogranel = entity.neogranel,
                granel = entity.granel,
                geral = entity.geral
            ),
            axis = entity.axis,
            fuelPrice = entity.fuelPrice,
            fuelConsumption = entity.fuelConsumption
        )
    }
}