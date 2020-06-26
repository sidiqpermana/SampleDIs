package com.nbs.sampledidip.domain

import com.nbs.sampledidip.data.entity.PersonEntity
import com.nbs.sampledidip.domain.model.Person

fun mapPerson(personEntities: List<PersonEntity>): List<Person> =
    personEntities.map {
        Person(
            id = it.id,
            name = it.name,
            email = it.email
        )
    }