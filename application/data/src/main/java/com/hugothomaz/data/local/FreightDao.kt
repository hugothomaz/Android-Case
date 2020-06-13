package com.hugothomaz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.hugothomaz.data.local.entity.FreightEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface FreightDao {

    @Insert
    fun insertFreight(freightEntity : FreightEntity) : Long

    @Transaction
    @Query("select * from freight")
    fun fetchAllFreights() : Maybe<List<FreightEntity>>

    @Transaction
    @Query("select * from freight where id = :id")
    fun fetchFreightByID(id : Long) : Maybe<FreightEntity>

}