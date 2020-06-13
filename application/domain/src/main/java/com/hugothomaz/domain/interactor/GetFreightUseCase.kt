package com.hugothomaz.domain.interactor

import com.hugothomaz.domain.exception.NotFoundID
import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Maybe

class GetFreightUseCase(private val repository: IFreightRepository) {

    fun getFreightByID(freightID: Long?): Maybe<FreightModel> {
        if (freightID == null) {
            return Maybe.error(NotFoundID("Frete não cadastrado"))
        } else {
            return repository.fetchFreightByID(freightID)
        }

    }

}