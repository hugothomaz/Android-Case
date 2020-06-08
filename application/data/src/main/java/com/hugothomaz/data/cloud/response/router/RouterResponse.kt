package com.hugothomaz.data.cloud.response.router

import com.google.gson.annotations.SerializedName
import com.hugothomaz.data.cloud.response.router.PointResponse

data class RouterResponse(
    @SerializedName("cached") val cached: Boolean,
    @SerializedName("distance") val distance: Int,
    @SerializedName("distance_unit") val distanceUnit: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("duration_unit") val durationUnit: String,
    @SerializedName("fuel_cost") val fuelCost: Double,
    @SerializedName("fuel_cost_unit") val fuelCostUnit: String,
    @SerializedName("fuel_usage") val fuelUsage: Double,
    @SerializedName("fuel_usage_unit") val fuelUsageUnit: String,
    @SerializedName("has_tolls") val hasTolls: Boolean,
    @SerializedName("pointResponses") val pointResponses: List<PointResponse>,
    @SerializedName("provider") val provider: String,
    @SerializedName("route") val route: List<List<List<Double>>>,
    @SerializedName("toll_cost") val tollCost: Double,
    @SerializedName("toll_cost_unit") val tollCostUnit: String,
    @SerializedName("toll_count") val tollCount: Int,
    @SerializedName("total_cost") val totalCost: Double
)