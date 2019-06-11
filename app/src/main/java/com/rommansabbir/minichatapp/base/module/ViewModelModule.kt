package com.rommansabbir.minichatapp.base.module

import androidx.lifecycle.ViewModel
import com.rommansabbir.minichatapp.base.viewmodel.ViewModelKey
import com.rommansabbir.minichatapp.screens.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Singleton
@Module
abstract class ViewModelModule {
    /**
     * 01-05-2019 by Romman
     */
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel) : ViewModel


}