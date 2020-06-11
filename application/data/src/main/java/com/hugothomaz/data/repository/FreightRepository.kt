package com.hugothomaz.data.repository

import com.hugothomaz.data.cloud.AppCloud
import com.hugothomaz.data.cloud.request.freight.FreightPriceRequest
import com.hugothomaz.data.local.FreightLocal
import com.hugothomaz.data.mapper.FeirghtEntityToModelMapper
import com.hugothomaz.data.mapper.FeirghtModelToEntityMapper
import com.hugothomaz.data.mapper.FeirghtResponseToModelMapper
import com.hugothomaz.data.mapper.RouterModelToRequestMapper
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Maybe
import io.reactivex.Single

class FreightRepository(
    private val appCloud: AppCloud,
    private val local: FreightLocal
) : IFreightRepository {

    override fun calcFreight(
        routerModel: RouterModel,
        hasReturnShipment: Boolean
    ): Single<FreightModel> {
        val mapperModelToRequest = RouterModelToRequestMapper()
        val mapperFeirghtResponseToModel = FeirghtResponseToModelMapper()
        val mapperFeirghtModelToEntity = FeirghtModelToEntityMapper()

        return appCloud.getRouter(mapperModelToRequest.transform(routerModel))
            .flatMap { router ->
                appCloud.getFreightPrice(
                    FreightPriceRequest(
                        axis = routerModel.axis,
                        distance = router.distance,
                        hasReturnShipment = hasReturnShipment
                    )
                ).map { freight ->
                    mapperFeirghtResponseToModel.transform(Pair(router, freight))
                }.map {
                    local.saveFreight(mapperFeirghtModelToEntity.transform(Pair(routerModel, it)))
                    it
                }
            }
    }

    override fun fetchFreightByID(
        id: Long
    ): Maybe<FreightModel> {
        val mapperFeirghtEntityToModel = FeirghtEntityToModelMapper()
        return local.fetchFreightByID(id).map {
            mapperFeirghtEntityToModel.transform(it)
        }
    }

    override fun fetchAllFreights(
    ): Maybe<List<FreightModel>> {
        val mapperFeirghtEntityToModel = FeirghtEntityToModelMapper()
        return local.fetchAllFreights().map {
            mapperFeirghtEntityToModel.transform(it)
        }
    }

}