package com.hugothomaz.data.cloud

import com.hugothomaz.data.cloud.request.router.RouterRequest
import com.hugothomaz.data.cloud.response.router.RouterResponse
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface GEOApi {

    @POST("/v1/route")
    fun getRouter(@Body routerRequest: RouterRequest) : Maybe<RouterResponse>

}