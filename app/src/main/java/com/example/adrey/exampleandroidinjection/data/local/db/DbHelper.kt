package com.example.adrey.exampleandroidinjection.data.local.db

import com.example.adrey.exampleandroidinjection.data.model.User
import io.reactivex.Observable

interface DbHelper {

    fun insertUser(user: User) : Observable<Long>

    fun getUser(idUser: Long) : Observable<User>
}