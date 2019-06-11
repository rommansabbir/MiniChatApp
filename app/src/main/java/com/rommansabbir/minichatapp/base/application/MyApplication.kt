package com.rommansabbir.minichatapp.base.application

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import com.rommansabbir.minichatapp.base.component.ApplicationComponent
import com.rommansabbir.minichatapp.base.component.DaggerApplicationComponent
import com.rommansabbir.minichatapp.base.module.ApplicationModule

class MyApplication : Application(){
    val component : ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }


    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }

    companion object {
        fun getApplicationComponent(context: Context): ApplicationComponent? {
            return (context.applicationContext as MyApplication).component
        }
    }
}