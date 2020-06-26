package com.nbs.sampledidip.domain

import com.nbs.sampledidip.domain.model.Person
import com.nbs.sampledidip.domain.model.PersonParam
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface PersonUseCase {
    fun getAll(): Flowable<List<Person>>

    fun save(personParam: PersonParam): Observable<Long>
}