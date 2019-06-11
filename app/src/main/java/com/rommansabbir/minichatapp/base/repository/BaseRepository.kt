package com.rommansabbir.minichatapp.base.repository

import com.google.firebase.database.*

object BaseRepository {

    fun valueEventListener(refPath : String, callback: ValueEventCallback){
        val databaseReference = FirebaseDatabase.getInstance().getReference(refPath)
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                callback.onFailure(p0)
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    callback.onSuccess(p0)
                }
            }

        })
    }


    fun childEventListener(refPath : String, callback: ChildEventCallback){
        val databaseReference = FirebaseDatabase.getInstance().getReference(refPath)
        databaseReference.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
                callback.onCancelled(p0)
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                callback.onChildMoved(p0, p1)
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                callback.onChildChanged(p0, p1)
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                callback.onChildAdded(p0,p1)
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                callback.onChildRemoved(p0)
            }

        })
    }


    fun singleEventListener(refPath : String, callback: ValueEventCallback){
        val databaseReference = FirebaseDatabase.getInstance().getReference(refPath)
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                onCancelled(p0)
            }
            override fun onDataChange(p0: DataSnapshot) {
                callback.onSuccess(p0)
            }

        })

    }

}