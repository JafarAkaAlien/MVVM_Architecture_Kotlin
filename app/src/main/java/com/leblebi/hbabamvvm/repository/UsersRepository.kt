package com.leblebi.hbabamvvm.repository

import android.content.Context
import com.leblebi.hbabamvvm.BaseRepository
import com.leblebi.hbabamvvm.model.User
import com.leblebi.hbabamvvm.model.UsersResponse
import retrofit2.Response

class UsersRepository(val context: Context):BaseRepository() {
    private val usersDao by lazy {
        getRoom(context).usersDao()
    }
    suspend fun getAllUsersFromRemote(page:Int, perPage:Int):Response<UsersResponse>{
        return httpExecute().getAllUsers(page,perPage)
    }

    suspend fun saveAllUsers(users:List<User>){
        usersDao.saveUsers(users)
    }
     fun getAllLocalUsers()= usersDao.getAllUsers()

}