package com.hugothomaz.data.mapper

import com.hugothomaz.data.local.entity.FreightEntity
import com.hugothomaz.domain.model.enums.DurationUnit
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.model.TypeOfCargoModel
import com.hugothomaz.domain.model.enums.DistanceUnitEnum
import com.hugothomaz.domain.model.enums.MoneyUnitEnum
import com.hugothomaz.domain.model.enums.VolumeUnitEnum

class FeirghtEntityToModelMapper : IMapper<FreightEntity, FreightModel> {

    override fun transform(entity: FreightEntity): FreightModel {
        return FreightModel(
            date = entity.date,
            distance = entity.distance,
            distanceUnit = DistanceUnitEnum.valueOf(entity.distanceUnit.toUpperCase()),
            duration = entity.duration,
            durationUnit = DurationUnit.valueOf(entity.durationUnit.toUpperCase()),
            hasToll = entity.hasToll,
            tollCost = entity.tollCost,
            tollCount = entity.tollCount,
            tollMoneyUnit = MoneyUnitEnum.valueOf(entity.tollMoneyUnit.toUpperCase()),
            fuelUsed = entity.fuelUsed,
            fuelUseUnit = VolumeUnitEnum.valueOf(entity.fuelUseUnit.toUpperCase()),
            fuelCost = entity.fuelCost,
            fuelMoneyUnit = MoneyUnitEnum.valueOf(entity.fuelMoneyUnit.toUpperCase()),
            totalCost = entity.totalCost,
            typeOfCargoModel = TypeOfCargoModel(
                frigorificada = entity.frigorificada,
                perigosa = entity.perigosa,
                neogranel = entity.neogranel,
                granel = entity.granel,
                geral = entity.geral
            )
        )
    }
}