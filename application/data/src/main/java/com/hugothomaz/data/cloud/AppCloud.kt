package com.hugothomaz.data.cloud

import com.hugothomaz.data.cloud.request.freight.FreightPriceRequest
import com.hugothomaz.data.cloud.request.router.RouterRequest
import com.hugothomaz.data.cloud.response.freight.FreightPriceResponse
import com.hugothomaz.data.cloud.response.router.RouterResponse
import io.reactivex.Single

class AppCloud(
    private val geoAPI: GEOApi,
    private val freightAPI: FreightAPI
) {

    fun getRouter(routerRequest: RouterRequest): Single<RouterResponse> {
        return geoAPI.getRouter(routerRequest)
    }

    fun getFreightPrice(freightPriceRequest: FreightPriceRequest): Single<FreightPriceResponse> {
        return freightAPI.getFreightPrice(freightPriceRequest)
    }

}