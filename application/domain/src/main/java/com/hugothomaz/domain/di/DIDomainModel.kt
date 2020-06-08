package com.hugothomaz.domain.di

import com.hugothomaz.domain.interactor.CalcFreightUseCase
import com.hugothomaz.domain.repository.IFreightRepository
import org.koin.dsl.module


val domainModel = module {

    factory { CalcFreightUseCase(get<IFreightRepository>()) }

}

