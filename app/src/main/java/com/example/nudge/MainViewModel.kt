package com.example.nudge

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.lifecycle.*
import com.example.nudge.Database.SquadDatabase
import com.example.nudge.Entity.PlayerEntity
import com.example.nudge.Entity.SquadEntity
import com.example.nudge.Entity.UserEntity
import com.example.nudge.Repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = SquadDatabase.getDatabase(context)

    private var _squadList = MutableLiveData<List<SquadEntity>>()
    val squadList : LiveData<List<SquadEntity>>
        get() = _squadList

    private var _userList = MutableLiveData<List<UserEntity>>()
    val userList : LiveData<List<UserEntity>>
        get() = _userList

    val repository = Repository(context)

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _squadList.postValue(repository.getSquadList())
        // _userList.postValue(repository.getUserList())
    }

    fun insertData(formation : Int, position : Int, name : String, key : String) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertSquadData(formation, position, name, key)
        // repository.insertUserData(id, name, formation)
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteSquadData()
        // repository.deleteUserData()
    }

    fun insertPlayerData(name : String, image : Drawable) = viewModelScope.launch(Dispatchers.IO) {
        val key = repository.uploadPlayerEntity(name)
        repository.uploadPlayerImage(key, image)
    }

    fun getPlayerData() : LiveData<MutableList<PlayerEntity>> {
        val playerEntityList = MutableLiveData<MutableList<PlayerEntity>>()
        repository.downloadPlayerEntity().observeForever {
            playerEntityList.value = it
        }
        return playerEntityList
    }

}