package com.rommansabbir.minichatapp.base.component

import com.rommansabbir.minichatapp.screens.view.MainActivity
import com.rommansabbir.minichatapp.base.module.ApplicationModule
import com.rommansabbir.minichatapp.base.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}