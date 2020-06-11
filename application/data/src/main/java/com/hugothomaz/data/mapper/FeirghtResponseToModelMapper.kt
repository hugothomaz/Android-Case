package com.hugothomaz.data.mapper

import com.hugothomaz.data.cloud.response.freight.FreightPriceResponse
import com.hugothomaz.data.cloud.response.router.RouterResponse
import com.hugothomaz.domain.model.enums.DurationUnit
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.model.TypeOfCargoModel
import com.hugothomaz.domain.model.enums.DistanceUnitEnum
import com.hugothomaz.domain.model.enums.MoneyUnitEnum
import com.hugothomaz.domain.model.enums.VolumeUnitEnum
import java.util.*

class FeirghtResponseToModelMapper : IMapper<Pair<RouterResponse, FreightPriceResponse>, FreightModel> {

    override fun transform(pair : Pair<RouterResponse, FreightPriceResponse> ): FreightModel {
        return FreightModel(
            distance = pair.first.distance,
            date = Date(),
            distanceUnit = DistanceUnitEnum.valueOf(pair.first.distanceUnit.toUpperCase()),
            duration = pair.first.duration,
            durationUnit = DurationUnit.valueOf(pair.first.durationUnit.toUpperCase()),
            fuelCost = pair.first.fuelCost,
            fuelMoneyUnit = MoneyUnitEnum.valueOf(pair.first.fuelCostUnit.toUpperCase()),
            fuelUsed = pair.first.fuelUsage,
            hasToll = pair.first.hasTolls,
            tollCost = pair.first.tollCost,
            tollCount = pair.first.tollCount,
            tollMoneyUnit = MoneyUnitEnum.valueOf(pair.first.tollCostUnit.toUpperCase()),
            totalCost = pair.first.totalCost,
            fuelUseUnit = VolumeUnitEnum.valueOf(pair.first.fuelUsageUnit.toUpperCase()),
            typeOfCargoModel = mapperFreightModel(pair.second)
        )
    }

    private fun mapperFreightModel(freightPriceResponse : FreightPriceResponse) : TypeOfCargoModel{
        return TypeOfCargoModel(
            frigorificada = freightPriceResponse.frigorificada,
            geral = freightPriceResponse.geral,
            granel = freightPriceResponse.granel,
            neogranel = freightPriceResponse.neogranel,
            perigosa = freightPriceResponse.perigosa
        )
    }

}