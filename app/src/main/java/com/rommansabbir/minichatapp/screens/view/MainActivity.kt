package com.rommansabbir.minichatapp.screens.view

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import com.rommansabbir.minichatapp.R
import com.rommansabbir.minichatapp.base.activity.BaseActivity
import com.rommansabbir.minichatapp.base.application.MyApplication
import com.rommansabbir.minichatapp.databinding.ActivityMainBinding
import com.rommansabbir.minichatapp.screens.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreated(instance: Bundle?) {
        binding.viewModel = viewModel
        viewModel.setupComponent(binding, this)
        viewModel.getUserMessages()
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun setupComponent(activity: Activity) {
        MyApplication.getApplicationComponent(this)!!.inject(this)
    }

    override fun processIntentData(data: Uri) {

    }

}
