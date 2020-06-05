package com.hugothomaz.data.mapper

import com.hugothomaz.data.cloud.response.freight.FreightPriceResponse
import com.hugothomaz.domain.model.FreightModel

class FeirghtResponseToModelMapper : IMapper<FreightPriceResponse, FreightModel> {

    override fun transform(entity: FreightPriceResponse): FreightModel {
        TODO("Not yet implemented")
    }
}