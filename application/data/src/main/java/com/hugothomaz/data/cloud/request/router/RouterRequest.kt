package com.hugothomaz.data.cloud.request.router

import com.google.gson.annotations.SerializedName
import com.hugothomaz.data.cloud.request.router.PlaceRequest

data class RouterRequest(
    @SerializedName("fuel_consumption") val fuelConsumption: Double,
    @SerializedName("fuel_price") val fuelPrice: Double,
    @SerializedName("places") val placeRequests: List<PlaceRequest>
)