package com.nbs.sampledidip.di

import com.nbs.sampledidip.data.DataStore
import com.nbs.sampledidip.data.Repository
import com.nbs.sampledidip.domain.PersonInteractor
import com.nbs.sampledidip.domain.PersonUseCase
import com.nbs.sampledidip.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val personFeatureModule = module {
    single<Repository>{
        DataStore(get())
    }

    single<PersonUseCase> {
        PersonInteractor(get())
    }

    viewModel {
        MainViewModel(
            compositeDisposable = get(),
            personUseCase = get()
        )
    }
}