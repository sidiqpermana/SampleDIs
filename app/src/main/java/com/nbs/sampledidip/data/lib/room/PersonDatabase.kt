package com.nbs.sampledidip.data.lib.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nbs.sampledidip.data.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun dao(): PersonDao

    companion object{
        @Volatile
        private var INSTANCE: PersonDatabase? = null

        fun getInstance(context: Context) : PersonDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "PersonDb"
                ).build()
            }

            return INSTANCE!!
        }

    }
}