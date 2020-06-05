package com.hugothomaz.data.mapper

import com.hugothomaz.data.cloud.request.router.PlaceRequest
import com.hugothomaz.data.cloud.request.router.RouterRequest
import com.hugothomaz.domain.model.RouterModel

class RouterModelToRequestMapper : IMapper<RouterModel, RouterRequest> {

    override fun transform(entity: RouterModel): RouterRequest {
        return RouterRequest(
            fuelConsumption = entity.fuelConsumption,
            fuelPrice = entity.fuelPrice,
            placeRequests = arrayListOf(
                PlaceRequest(
                    arrayListOf(
                        entity.pointModelStart.latitude,
                        entity.pointModelStart.longitude
                    )
                ),
                PlaceRequest(
                    arrayListOf(
                        entity.pointModelEnd.latitude,
                        entity.pointModelEnd.longitude
                    )
                )
            )
        )
    }

}