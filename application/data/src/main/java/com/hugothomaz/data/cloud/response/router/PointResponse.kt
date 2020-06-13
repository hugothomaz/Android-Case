package com.hugothomaz.data.cloud.response.router

import com.google.gson.annotations.SerializedName

data class PointResponse(
    @SerializedName("point") val point: List<Double>,
    @SerializedName("provider") val provider: String
)