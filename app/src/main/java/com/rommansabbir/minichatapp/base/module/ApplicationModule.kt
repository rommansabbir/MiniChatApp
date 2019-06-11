package com.rommansabbir.minichatapp.base.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Module
class ApplicationModule constructor(private val context: Context){

    @Provides
    fun provideApplicationContent() : Context {
        return context
    }
}