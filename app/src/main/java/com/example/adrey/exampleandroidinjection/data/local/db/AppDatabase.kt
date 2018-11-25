package com.example.adrey.exampleandroidinjection.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.adrey.exampleandroidinjection.data.local.db.dao.UserDao
import com.example.adrey.exampleandroidinjection.data.model.User

@Database(entities = [(User::class)], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}