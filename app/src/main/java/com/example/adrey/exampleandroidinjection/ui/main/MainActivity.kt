package com.example.adrey.exampleandroidinjection.ui.main

import android.os.Bundle
import android.widget.Toast
import com.example.adrey.exampleandroidinjection.BR
import com.example.adrey.exampleandroidinjection.R
import com.example.adrey.exampleandroidinjection.databinding.ActivityMainBinding
import com.example.adrey.exampleandroidinjection.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private var activityMainBinding: ActivityMainBinding? = null

    override fun getBindingVariable(): Int = BR.main

    override fun getViewModel(): MainViewModel = mainViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.setNavigator(this)
        activityMainBinding = getViewBinding()
    }

    override fun login() {
        val username = ed_username.text.toString()
        val password = ed_password.text.toString()
        if (mainViewModel.ifUsenamePasswordValid(username, password))
            mainViewModel.onLogin(username, password)
    }

    override fun setUsernameError() {
        ed_username.error = "Username not valid"
    }

    override fun setPasswordError() {
        ed_password.error = "Password not valid"
    }

    override fun showErrorLogin() {
        Toast.makeText(this, "Username and Password not same", Toast.LENGTH_SHORT).show()
    }

    override fun showHomeActivity(idUser: Long) {
        Toast.makeText(this, "Show Home Activity $idUser", Toast.LENGTH_SHORT).show()
    }
}
