package com.hugothomaz.domain.interactor

import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Maybe

class GetFreightUseCase(private val repository: IFreightRepository) {

    fun execute(freightID : Long) : Maybe<FreightModel>{
        return repository.fetchFreightByID(freightID)
    }

}