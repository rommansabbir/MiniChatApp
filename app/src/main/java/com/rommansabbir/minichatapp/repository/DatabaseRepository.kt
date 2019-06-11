package com.rommansabbir.minichatapp.repository

import com.rommansabbir.minichatapp.base.repository.BaseRepository
import com.rommansabbir.minichatapp.base.repository.ValueEventCallback
import com.rommansabbir.minichatapp.utils.Constants

object DatabaseRepository {

    fun getMessages(callback: ValueEventCallback){
        BaseRepository.valueEventListener(Constants.FIREBASE_MESSAGE_NODE,callback)
    }
}