package com.hugothomaz.data.local

import com.hugothomaz.data.local.entity.FreightEntity
import io.reactivex.Maybe
import io.reactivex.Single

class FreightLocal(private val dao: FreightDao) {

    fun saveFreight(freightEntity: FreightEntity) : Single<Long>{
        return dao.insertFreight(freightEntity)
    }

    fun fetchFreightByID(id : Long) : Maybe<FreightEntity>{
        return dao.fetchFreightByID(id)
    }

    fun fetchAllFreights() : Maybe<List<FreightEntity>> {
        return dao.fetchAllFreights()
    }

}