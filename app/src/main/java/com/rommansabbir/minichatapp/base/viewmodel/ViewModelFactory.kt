package com.rommansabbir.minichatapp.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject
internal constructor(private val viewModels: Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            return viewModels[modelClass]!!.get() as T
        } catch (e: Exception) {
            throw RuntimeException("Error creating view model for class: " + modelClass.simpleName, e)
        }

    }
}