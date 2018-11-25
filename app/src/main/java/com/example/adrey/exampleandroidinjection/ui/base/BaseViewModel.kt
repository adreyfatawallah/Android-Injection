package com.example.adrey.exampleandroidinjection.ui.base

import android.arch.lifecycle.ViewModel
import com.example.adrey.exampleandroidinjection.data.DataManager
import com.example.adrey.exampleandroidinjection.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel<N>(private val dataManager: DataManager,
                            private val schedulerProvider: SchedulerProvider) : ViewModel() {

    private var navigator: N? = null

    private var composite = CompositeDisposable()

    fun getNavigator() = navigator

    fun setNavigator(navigator: N) {
        this.navigator = navigator
    }

    fun getDataManager() : DataManager = dataManager

    fun getScheduler() : SchedulerProvider = schedulerProvider

    fun getComposite() : CompositeDisposable = composite

    override fun onCleared() {
        super.onCleared()
        composite.clear()
    }
}