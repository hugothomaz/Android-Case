package com.hugothomaz.domain.interactor

import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.model.RouterModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Maybe
import io.reactivex.Single

class CalcFreightUseCase(private val repository: IFreightRepository) {

    fun execute(routerModel : RouterModel, hasReturnShipment: Boolean) : Maybe<FreightModel>{
        return repository.calcFreight(routerModel, hasReturnShipment)
    }

}