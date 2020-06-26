package com.nbs.sampledidip.data.lib.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbs.sampledidip.data.entity.PersonEntity
import io.reactivex.Flowable

@Dao
interface PersonDao {
    @Query("SELECT * FROM person")
    fun getAll(): Flowable<List<PersonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(personEntity: PersonEntity): Long
}