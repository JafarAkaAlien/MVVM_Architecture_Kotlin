package com.leblebi.hbabamvvm.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.leblebi.hbabamvvm.BaseViewModel
import com.leblebi.hbabamvvm.model.User
import com.leblebi.hbabamvvm.repository.UsersRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application):BaseViewModel(application){
    private val _remoteUsers = MutableLiveData<List<User>>()
    val remoteUsers : LiveData<List<User>> = _remoteUsers

    private val usersRepository by lazy { UsersRepository(application.applicationContext)}

    fun getAllUsers() =usersRepository.getAllLocalUsers()
     fun saveUsers(users : List<User>) {
         viewModelScope.launch {
             usersRepository.saveAllUsers(users)
         }
     }

    fun saveUser(user: User){
        viewModelScope.launch {
            //usersRepository.saveUser(user)
        }
    }

    fun getAllRometeUsers(page:Int, pageNumber:Int){
        viewModelScope.launch {
            val response = usersRepository.getAllUsersFromRemote(page,pageNumber)
            if(response.isSuccessful && response.code()==200){
                response.body()?.let {
                    _remoteUsers.postValue(it.data)
                    _problem.postValue(false)
                }?: run{_problem.postValue(true)}
            }
            else{
                _problem.postValue(true)
            }
        }
    }

}