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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class FreightRepository(
    private val appCloud: AppCloud,
    private val local: FreightLocal
) : IFreightRepository {

    override fun calcFreight(
        routerModel: RouterModel,
        hasReturnShipment: Boolean
    ): Maybe<FreightModel> {
        val mapperModelToRequest = RouterModelToRequestMapper()
        val mapperFeirghtResponseToModel = FeirghtResponseToModelMapper()
        val mapperFeirghtModelToEntity = FeirghtModelToEntityMapper()
        val mapperFeirghtEntityToModel = FeirghtEntityToModelMapper()

        return appCloud.getRouter(mapperModelToRequest.transform(routerModel))
            .retry(2)
            .flatMap { router ->
                appCloud
                    .getFreightPrice(
                    FreightPriceRequest(
                        axis = routerModel.axis,
                        distance = router.distance,
                        hasReturnShipment = hasReturnShipment
                    )
                ).retry(2)
                    .map { freight ->
                    val map = hashMapOf<String, Any>()
                    map.put(FeirghtResponseToModelMapper.ROUTER_RESPONSE, router as Any)
                    map.put(FeirghtResponseToModelMapper.ROUTER_MODEL, routerModel as Any)
                    map.put(FeirghtResponseToModelMapper.FREIGHT_PRICE_RESPONSE, freight as Any)

                    mapperFeirghtResponseToModel.transform(map)
                }.map {
                    local.saveFreight(mapperFeirghtModelToEntity.transform(Pair(routerModel, it)))
                }.flatMap { id ->
                    local.fetchFreightByID(id)
                }.flatMap {
                    Maybe.just(mapperFeirghtEntityToModel.transform(it))
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