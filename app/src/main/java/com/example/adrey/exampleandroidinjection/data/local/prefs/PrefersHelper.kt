package com.example.adrey.exampleandroidinjection.data.local.prefs

interface PrefersHelper {

    fun setUsername(username: String)

    fun getUsername() : String

    fun setPassword(password: String)

    fun getPassword() : String
}