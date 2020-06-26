package com.nbs.sampledidip.data

import com.nbs.sampledidip.data.lib.room.PersonDao
import com.nbs.sampledidip.data.request.PersonRequest
import com.nbs.sampledidip.data.entity.PersonEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class DataStore(private val db: PersonDao) : Repository{
    override fun getAll(): Flowable<List<PersonEntity>> {
        return db.getAll()
    }

    override fun save(personRequest: PersonRequest): Observable<Long> {
        return Observable.fromCallable {
            db.save(
                PersonEntity(
                    name = personRequest.name, email = personRequest.email
                )
            )
        }
    }
}