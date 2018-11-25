package com.example.adrey.exampleandroidinjection.di.builder

import com.example.adrey.exampleandroidinjection.ui.main.MainActivity
import com.example.adrey.exampleandroidinjection.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity() : MainActivity
}