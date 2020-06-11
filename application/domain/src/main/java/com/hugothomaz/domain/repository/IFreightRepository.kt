package com.hugothomaz.domain.repository

import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import io.reactivex.Maybe
import io.reactivex.Single

interface IFreightRepository {

    fun calcFreight(
        routerModel: RouterModel,
        hasReturnShipment: Boolean
    ): Single<FreightModel>

    fun fetchFreightByID(
        id : Long
    ): Maybe<FreightModel>

    fun fetchAllFreights(
    ): Maybe<List<FreightModel>>

}