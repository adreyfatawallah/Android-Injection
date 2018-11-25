package com.example.adrey.exampleandroidinjection.data

import android.content.Context
import com.example.adrey.exampleandroidinjection.data.local.db.DbHelper
import com.example.adrey.exampleandroidinjection.data.local.prefs.PrefersHelper
import com.example.adrey.exampleandroidinjection.data.model.User
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject constructor(private val context: Context,
                                         private val dbHelper: DbHelper,
                                         private val prefersHelper: PrefersHelper) : DataManager {

    override fun insertUser(user: User): Observable<Long> = dbHelper.insertUser(user)

    override fun getUser(idUser: Long): Observable<User> = dbHelper.getUser(idUser)

    override fun setUsername(username: String) {
        prefersHelper.setUsername(username)
    }

    override fun getUsername(): String = prefersHelper.getUsername()

    override fun setPassword(password: String) {
        prefersHelper.setPassword(password)
    }

    override fun getPassword(): String = prefersHelper.getPassword()
}