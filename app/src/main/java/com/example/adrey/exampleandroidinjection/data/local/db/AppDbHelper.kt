package com.example.adrey.exampleandroidinjection.data.local.db

import com.example.adrey.exampleandroidinjection.data.model.User
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject constructor(private val appDatabase: AppDatabase) : DbHelper {

    override fun insertUser(user: User): Observable<Long> {
        return Observable.fromCallable {
            return@fromCallable appDatabase.userDao().insertUser(user)
        }
    }

    override fun getUser(idUser: Long): Observable<User> {
        return Observable.fromCallable {
            return@fromCallable appDatabase.userDao().getUser(idUser)
        }
    }
}