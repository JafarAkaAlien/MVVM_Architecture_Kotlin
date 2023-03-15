package com.leblebi.hbabamvvm.data.local

import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Database
import com.leblebi.hbabamvvm.model.User


@Database(entities = [User::class] , version = 1)
abstract class MyRoomDatabase:RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object{
        private var INSTANCE: MyRoomDatabase?=null

        fun getInstance(context: Context):MyRoomDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MyRoomDatabase::class.java, "my_database").build()
            }
            return INSTANCE!!
        }
    }
}