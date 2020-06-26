package com.nbs.sampledidip.data.lib.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nbs.sampledidip.data.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun dao(): PersonDao
}