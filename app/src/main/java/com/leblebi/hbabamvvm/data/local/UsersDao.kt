package com.leblebi.hbabamvvm.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.leblebi.hbabamvvm.model.User
import retrofit2.Response

@Dao
interface UsersDao {
    @Query("Select * From users")
    fun getAllUsers():LiveData<List<User>>

    @Insert
    suspend fun saveUser(user: User)

    @Insert
    suspend fun saveUsers(users : List<User>)

    @Delete
    suspend fun deleteUser(user:User)

    @Update
    suspend fun updateUser(user:User)

}