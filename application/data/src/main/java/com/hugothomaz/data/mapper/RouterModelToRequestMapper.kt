package com.hugothomaz.data.mapper

import com.hugothomaz.data.cloud.request.router.PlaceRequest
import com.hugothomaz.data.cloud.request.router.RouterRequest
import com.hugothomaz.domain.model.PointModel
import com.hugothomaz.domain.model.RouterModel

class RouterModelToRequestMapper : IMapper<RouterModel, RouterRequest> {

    override fun transform(entity: RouterModel): RouterRequest {
        return RouterRequest(
            fuelConsumption = entity.fuelConsumption,
            fuelPrice = entity.fuelPrice,
            placeRequests = arrayListOf(
                placeRequest(entity.pointModelStart),
                placeRequest(entity.pointModelEnd)
            )
        )
    }


    private fun placeRequest(point : PointModel?) : PlaceRequest{
        if(point == null){
            return PlaceRequest(
                arrayListOf()
            )
        }

        return PlaceRequest(
            arrayListOf(
                point.longitude,
                point.latitude
            )
        )
    }

}