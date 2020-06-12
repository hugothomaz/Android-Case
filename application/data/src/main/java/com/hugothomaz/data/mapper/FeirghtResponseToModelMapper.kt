package com.hugothomaz.data.mapper

import com.hugothomaz.data.cloud.response.freight.FreightPriceResponse
import com.hugothomaz.data.cloud.response.router.RouterResponse
import com.hugothomaz.domain.model.enums.DurationUnit
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.model.TypeOfCargoModel
import com.hugothomaz.domain.model.enums.DistanceUnitEnum
import com.hugothomaz.domain.model.enums.VolumeUnitEnum
import java.util.*

class FeirghtResponseToModelMapper : IMapper<Map<String, Any>, FreightModel> {
    //RouterResponse, FreightPriceResponse
    companion object{
        const val ROUTER_RESPONSE = "router_response"
        const val ROUTER_MODEL = "router_model"
        const val FREIGHT_PRICE_RESPONSE = "freight_price_response"
    }


    override fun transform(map : Map<String, Any> ): FreightModel {
        val routerResponse = map.get(ROUTER_RESPONSE) as RouterResponse
        val routerModel = map.get(ROUTER_MODEL) as RouterModel
        val freightPriceModel = map.get(FREIGHT_PRICE_RESPONSE) as FreightPriceResponse


        return FreightModel(
            distance = routerResponse.distance,
            date = Date(),
            distanceUnit = DistanceUnitEnum.valueOf(routerResponse.distanceUnit.toUpperCase()),
            duration = routerResponse.duration,
            durationUnit = DurationUnit.valueOf(routerResponse.durationUnit.toUpperCase()),
            fuelCost = routerResponse.fuelCost,
            fuelMoneyUnit = routerResponse.fuelCostUnit,
            fuelUsed = routerResponse.fuelUsage,
            hasToll = routerResponse.hasTolls,
            tollCost = routerResponse.tollCost,
            tollCount = routerResponse.tollCount,
            tollMoneyUnit = routerResponse.tollCostUnit,
            totalCost = routerResponse.totalCost,
            fuelUseUnit = VolumeUnitEnum.valueOf(routerResponse.fuelUsageUnit.toUpperCase()),
            typeOfCargoModel = mapperFreightModel(freightPriceModel),
            axis = routerModel.axis,
            fuelConsumption = routerModel.fuelConsumption,
            fuelPrice = routerModel.fuelPrice
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