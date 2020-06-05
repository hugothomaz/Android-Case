package com.hugothomaz.domain.interactor

import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Single

class CalcFreightUseCase(val repository: IFreightRepository) {

    fun execute(routerModel : RouterModel, hasReturnShipment: Boolean) : Single<FreightModel>{
        return repository.calcFreight(routerModel, hasReturnShipment)
    }

}