package com.hugothomaz.data.repository

import com.hugothomaz.data.cloud.AppCloud
import com.hugothomaz.data.cloud.request.freight.FreightPriceRequest
import com.hugothomaz.data.mapper.FeirghtResponseToModelMapper
import com.hugothomaz.data.mapper.RouterModelToRequestMapper
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Single

class FreightRepository(
    private val appCloud: AppCloud
) : IFreightRepository {

    override fun calcFreight(
        routerModel: RouterModel,
        hasReturnShipment: Boolean
    ): Single<FreightModel> {
        val mapperModelToRequest = RouterModelToRequestMapper()
        val feirghtResponseToModelMapper = FeirghtResponseToModelMapper()

        return appCloud.getRouter(mapperModelToRequest.transform(routerModel))
            .flatMap {router ->
                appCloud.getFreightPrice(
                    FreightPriceRequest(
                        axis = routerModel.axis,
                        distance = router.distance,
                        hasReturnShipment = hasReturnShipment
                    )
                ).map {freight ->
                    feirghtResponseToModelMapper.transform(freight)
                }
            }
    }

}