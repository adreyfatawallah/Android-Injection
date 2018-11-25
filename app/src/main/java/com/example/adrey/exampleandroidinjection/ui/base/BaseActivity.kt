package com.example.adrey.exampleandroidinjection.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity<T: ViewDataBinding, V: BaseViewModel<*>> : AppCompatActivity() {

    private var viewDataBinding: T? = null
    private var viewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        performDataBinding()
    }

    abstract fun getBindingVariable(): Int

    abstract fun getViewModel(): V

    abstract fun getLayoutId(): Int

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.viewModel = if (viewModel == null) getViewModel() else viewModel
        viewDataBinding?.setVariable(getBindingVariable(), viewModel)
        viewDataBinding?.executePendingBindings()
    }

    fun getViewBinding() : T? = viewDataBinding
}