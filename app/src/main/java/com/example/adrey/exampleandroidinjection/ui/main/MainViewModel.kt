package com.example.adrey.exampleandroidinjection.ui.main

import android.databinding.ObservableBoolean
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import com.example.adrey.exampleandroidinjection.data.DataManager
import com.example.adrey.exampleandroidinjection.data.model.User
import com.example.adrey.exampleandroidinjection.ui.base.BaseViewModel
import com.example.adrey.exampleandroidinjection.utils.rx.SchedulerProvider

class MainViewModel (dataManager: DataManager, schedulerProvider: SchedulerProvider) :
        BaseViewModel<MainNavigator>(dataManager, schedulerProvider) {

    var isLoading = ObservableBoolean(false)

    var idUser: Long = -1

    fun ifUsenamePasswordValid(username: String, password: String) : Boolean {
        if (TextUtils.isEmpty(username)) {
            getNavigator()?.setUsernameError()
            return false
        }
        if (TextUtils.isEmpty(password)) {
            getNavigator()?.setPasswordError()
            return false
        }
        return true
    }

    fun login() {
        getNavigator()?.login()
    }

    fun onLogin(username: String, password: String) {
        setIsLoading(true)
        if (username != password)
            getComposite().add(getDataManager().insertUser(User(username, password))
                    .observeOn(getScheduler().ui())
                    .subscribeOn(getScheduler().io())
                    .subscribe {
                        Handler().postDelayed({
                            idUser = it
                            getDataManager().setUsername(username)
                            getDataManager().setPassword(password)
                            getNavigator()?.showHomeActivity(it)
                            setIsLoading(false)
                        }, 2000)
                    })
        else
            Handler().postDelayed({
                getNavigator()?.showErrorLogin()
                setIsLoading(false)
            }, 2000)
    }

    private fun setIsLoading(loading: Boolean) {
        isLoading.set(loading)
    }

    fun getUser(idUser: Long) {
        getComposite().add(getDataManager().getUser(idUser)
                .observeOn(getScheduler().ui())
                .subscribeOn(getScheduler().io())
                .subscribe {
                    Log.e("USER DB", it.toString())
                    Log.e("USER PREF", getDataManager().getUsername())
                    Log.e("USER PREF", getDataManager().getPassword())
                })
    }
}