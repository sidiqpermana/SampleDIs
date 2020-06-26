package com.nbs.sampledidip.di

import com.nbs.sampledidip.data.DataStore
import com.nbs.sampledidip.data.Repository
import com.nbs.sampledidip.domain.PersonInteractor
import com.nbs.sampledidip.domain.PersonUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
abstract class PersonDomainModule {
    @ActivityScoped
    @Binds
    abstract fun providePersonUseCase(impl: PersonInteractor): PersonUseCase
}

@InstallIn(ApplicationComponent::class)
@Module
abstract class PersonDataStoreModule{
    @Singleton
    @Binds
    abstract fun providePersonRepository(impl: DataStore): Repository
}