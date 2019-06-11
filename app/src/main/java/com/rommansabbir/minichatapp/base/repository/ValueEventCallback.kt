package com.rommansabbir.minichatapp.base.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

interface ValueEventCallback {
    fun onSuccess(dataSnapshot: DataSnapshot)
    fun onFailure(databaseError: DatabaseError)
}