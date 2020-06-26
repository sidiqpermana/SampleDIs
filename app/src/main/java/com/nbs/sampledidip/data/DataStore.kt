package com.nbs.sampledidip.data

import com.nbs.sampledidip.data.lib.room.PersonDao
import com.nbs.sampledidip.data.request.PersonRequest
import com.nbs.sampledidip.data.entity.PersonEntity
import dagger.hilt.android.scopes.ActivityScoped
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStore @Inject constructor(private val db: PersonDao) : Repository{
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