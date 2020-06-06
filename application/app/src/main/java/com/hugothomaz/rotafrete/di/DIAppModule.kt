package com.hugothomaz.rotafrete.di

import com.hugothomaz.rotafrete.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel() }


}