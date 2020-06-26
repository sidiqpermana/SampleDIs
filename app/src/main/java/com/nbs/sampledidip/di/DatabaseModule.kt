package com.nbs.sampledidip.di

import android.content.Context
import androidx.room.Room
import com.nbs.sampledidip.data.lib.room.PersonDao
import com.nbs.sampledidip.data.lib.room.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providePersonDatabase(@ApplicationContext applicationContext: Context): PersonDatabase {
        return  Room.databaseBuilder(
            applicationContext,
            PersonDatabase::class.java,
            "PersonDb"
        ).build()
    }

    @Singleton
    @Provides
    fun providePersonDao(personDatabase: PersonDatabase): PersonDao{
        return personDatabase.dao()
    }
}