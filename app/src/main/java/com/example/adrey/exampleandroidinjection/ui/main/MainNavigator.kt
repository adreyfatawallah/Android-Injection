package com.example.adrey.exampleandroidinjection.ui.main

interface MainNavigator {

    fun login()

    fun setUsernameError()

    fun setPasswordError()

    fun showErrorLogin()

    fun showHomeActivity(idUser: Long)
}