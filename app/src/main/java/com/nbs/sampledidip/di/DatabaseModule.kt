package com.nbs.sampledidip.di

import com.nbs.sampledidip.data.lib.room.PersonDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        PersonDatabase.getInstance(get())
    }
    single {
        val app = get<PersonDatabase>()
        return@single app.dao()
    }
}