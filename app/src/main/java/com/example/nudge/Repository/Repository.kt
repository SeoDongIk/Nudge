package com.example.nudge.Repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nudge.Database.SquadDatabase
import com.example.nudge.Entity.PlayerEntity
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.UserEntity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.*
import java.io.ByteArrayOutputStream


class Repository(context : Context) {

    // inner_db is ROOM

    val inner_db = SquadDatabase.getDatabase(context)

    fun getSquadList() = inner_db.squadDao().getAllData()

    //fun getUserList() = inner_db.userDao().getAllData()

    fun insertSquadData(formation : Int, position : Int, name : String, key : String) = inner_db.squadDao().insert(SquadEntity(formation, position, name, key))

    // fun insertUserData(id : Int, name : String, formation : String) = inner_db.userDao().insert(UserEntity(id, name, formation))

    fun deleteSquadData() = inner_db.squadDao().deleteAllData()

    // fun deleteUserData() = inner_db.userDao().deleteAllData()

    // outer_db is Firebase Realtime DB + Firbase Storage

    val outer_db = Firebase.database
    val outer_image_db = Firebase.storage

    fun uploadPlayerEntity(player_name : String) : String {
        val playerRef = outer_db.getReference("player")
        val key : String = playerRef.push().key.toString()
        playerRef.child(key).setValue(PlayerEntity(player_name, key))
        return key
    }

    fun downloadPlayerEntity() : LiveData<MutableList<PlayerEntity>> {
        val livePlayerEntityList = MutableLiveData<MutableList<PlayerEntity>>()
        val postListener = object : ValueEventListener {
            val playerEntityList : MutableList<PlayerEntity> = mutableListOf<PlayerEntity>()
            override fun onDataChange(snapshot: DataSnapshot) {
                playerEntityList.clear()
                for (dataModel in snapshot.children) {
                    val item = dataModel.getValue(PlayerEntity::class.java)
                    playerEntityList.add(item!!)
                    livePlayerEntityList.value = playerEntityList
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        outer_db.getReference("player").addValueEventListener(postListener)
        Log.d("download", livePlayerEntityList.toString())
        return livePlayerEntityList
    }

    fun uploadPlayerImage(key : String, image : Drawable){
        val playerRef = outer_image_db.reference.child(key+".png")
        val bitmap = (image as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)

        val data = baos.toByteArray()
        var uploadTask = playerRef.putBytes(data)

        uploadTask.addOnFailureListener {
            //
        }.addOnSuccessListener { taskSnapshot ->
            //
        }
    }

}