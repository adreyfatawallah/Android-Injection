package com.example.adrey.exampleandroidinjection.ui.main

import com.example.adrey.exampleandroidinjection.data.DataManager
import dagger.Module
import dagger.Provides
import com.example.adrey.exampleandroidinjection.utils.rx.SchedulerProvider


@Module
class MainActivityModule {

    @Provides
    fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): MainViewModel
            = MainViewModel(dataManager, schedulerProvider)
}