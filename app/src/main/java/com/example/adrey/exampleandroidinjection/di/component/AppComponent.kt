package com.example.adrey.exampleandroidinjection.di.component

import android.app.Application
import com.example.adrey.exampleandroidinjection.di.builder.ActivityBuilder
import com.example.adrey.exampleandroidinjection.di.module.AppModule
import com.example.adrey.exampleandroidinjection.utils.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

    fun inject(app: App)
}