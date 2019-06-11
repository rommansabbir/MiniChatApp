package com.rommansabbir.minichatapp.screens.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.rommansabbir.minichatapp.screens.view.MainActivity
import com.rommansabbir.minichatapp.base.repository.ValueEventCallback
import com.rommansabbir.minichatapp.databinding.ActivityMainBinding
import com.rommansabbir.minichatapp.repository.DatabaseRepository
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var activity: MainActivity

    fun setupComponent(binding: ActivityMainBinding, activity: MainActivity){
        this.binding= binding
        this.activity = activity
    }

    fun getUserMessages(){
        DatabaseRepository.getMessages(object : ValueEventCallback{
            override fun onSuccess(dataSnapshot: DataSnapshot) {
                Log.d("TAG", "TAG")
            }

            override fun onFailure(databaseError: DatabaseError) {
                Log.d("TAG", "TAG")
            }

        })
    }

}