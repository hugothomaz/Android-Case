package com.hugothomaz.domain.interactor

import com.hugothomaz.domain.model.FreightModel
import com.hugothomaz.domain.repository.IFreightRepository
import io.reactivex.Maybe

class GetAllFreightUseCase(private val repository: IFreightRepository) {

    fun fetchAllFreight() : Maybe<List<FreightModel>>{
        return repository.fetchAllFreights()
    }

}