package com.example.adrey.exampleandroidinjection.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.adrey.exampleandroidinjection.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPrefersHelper @Inject constructor(context: Context, @PreferenceInfo prefFileName: String) : PrefersHelper {

    companion object {
        private const val PREF_KEY_USERNAME = "username"
        private const val PREF_KEY_PASSWORD = "password"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun setUsername(username: String) {
        prefs.edit().putString(PREF_KEY_USERNAME, username).apply()
    }

    override fun getUsername(): String = prefs.getString(PREF_KEY_USERNAME, "")

    override fun setPassword(password: String) {
        prefs.edit().putString(PREF_KEY_PASSWORD, password).apply()
    }

    override fun getPassword(): String = prefs.getString(PREF_KEY_PASSWORD, "")
}