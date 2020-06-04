package com.hugothomaz.data.cloud.response.freight

import com.google.gson.annotations.SerializedName

data class FreightPriceResponse(
    @SerializedName("frigorificada") val frigorificada: Double,
    @SerializedName("geral") val geral: Double,
    @SerializedName("granel") val granel: Double,
    @SerializedName("neogranel") val neogranel: Double,
    @SerializedName("perigosa") val perigosa: Double
)