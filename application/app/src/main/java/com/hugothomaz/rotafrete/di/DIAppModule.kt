package com.hugothomaz.rotafrete.di

import com.hugothomaz.domain.interactor.CalcFreightUseCase
import com.hugothomaz.domain.interactor.GetAllFreightUseCase
import com.hugothomaz.domain.interactor.GetFreightUseCase
import com.hugothomaz.rotafrete.screen.freight.FreightViewModel
import com.hugothomaz.rotafrete.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(get<GetFreightUseCase>(), get<GetAllFreightUseCase>()) }

    viewModel { FreightViewModel(get<CalcFreightUseCase>(), get<GetFreightUseCase>()) }

}