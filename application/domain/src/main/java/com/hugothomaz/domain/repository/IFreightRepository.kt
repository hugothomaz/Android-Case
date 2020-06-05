package com.hugothomaz.domain.repository

import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import io.reactivex.Single

interface IFreightRepository {

    fun calcFreight(
        routerModel: RouterModel,
        hasReturnShipment: Boolean
    ): Single<FreightModel>

}