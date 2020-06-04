package com.hugothomaz.data.cloud.request.freight

import com.google.gson.annotations.SerializedName

data class FreightPriceRequest(
    @SerializedName("axis") val axis: Int,
    @SerializedName("distance") val distance: Double,
    @SerializedName("has_return_shipment") val hasReturnShipment: Boolean
)