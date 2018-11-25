package com.example.adrey.exampleandroidinjection.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.example.adrey.exampleandroidinjection.data.AppDataManager
import com.example.adrey.exampleandroidinjection.data.DataManager
import com.example.adrey.exampleandroidinjection.data.local.db.AppDatabase
import com.example.adrey.exampleandroidinjection.data.local.db.AppDbHelper
import com.example.adrey.exampleandroidinjection.data.local.db.DbHelper
import com.example.adrey.exampleandroidinjection.data.local.prefs.AppPrefersHelper
import com.example.adrey.exampleandroidinjection.data.local.prefs.PrefersHelper
import com.example.adrey.exampleandroidinjection.di.DatabaseInfo
import com.example.adrey.exampleandroidinjection.di.PreferenceInfo
import com.example.adrey.exampleandroidinjection.utils.AppConst
import com.example.adrey.exampleandroidinjection.utils.rx.AppSchedulerProvider
import com.example.adrey.exampleandroidinjection.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application) : Context = application

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context) : AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()

    @Provides
    @Singleton
    fun provideAppDataManager(appDataManager: AppDataManager) : DataManager = appDataManager

    @Provides
    @DatabaseInfo
    fun provideDatabaseName() : String = AppConst.DB_NAME

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper) : DbHelper = appDbHelper

    @Provides
    @PreferenceInfo
    fun providePreferenceName() : String = AppConst.PREF_NAME

    @Provides
    @Singleton
    fun providePrefersHelper(appPrefersHelper: AppPrefersHelper) : PrefersHelper = appPrefersHelper

    @Provides
    @Singleton
    fun provideSchedulerProvider() : SchedulerProvider = AppSchedulerProvider()
}