package com.nbs.sampledidip.domain

import com.nbs.sampledidip.data.Repository
import com.nbs.sampledidip.data.request.PersonRequest
import com.nbs.sampledidip.domain.model.Person
import com.nbs.sampledidip.domain.model.PersonParam
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class PersonInteractor(private val repository: Repository) : PersonUseCase {
    override fun getAll(): Flowable<List<Person>> {
        return repository.getAll().map {
            mapPerson(it)
        }
    }

    override fun save(personParam: PersonParam): Observable<Long> {
        return repository.save(
            PersonRequest(
                name = personParam.name,
                email = personParam.email
            )
        )
    }
}