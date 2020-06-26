package com.nbs.sampledidip.data

import com.nbs.sampledidip.data.entity.PersonEntity
import com.nbs.sampledidip.data.request.PersonRequest
import io.reactivex.Flowable
import io.reactivex.Observable

interface Repository {
    fun getAll(): Flowable<List<PersonEntity>>

    fun save(personRequest: PersonRequest) : Observable<Long>
}