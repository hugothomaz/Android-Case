package com.hugothomaz.data.cloud

import com.hugothomaz.data.cloud.request.freight.FreightPriceRequest
import com.hugothomaz.data.cloud.response.freight.FreightPriceResponse
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface FreightAPI {

    @POST("/v1/antt_price/all")
    fun getFreightPrice(@Body FreightPriceRequest : FreightPriceRequest) : Maybe<FreightPriceResponse>

}