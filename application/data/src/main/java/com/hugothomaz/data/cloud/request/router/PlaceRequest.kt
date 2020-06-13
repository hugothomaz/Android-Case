package com.hugothomaz.data.cloud.request.router

import com.google.gson.annotations.SerializedName

data class PlaceRequest(
    @SerializedName("point") val point: List<Double>
)