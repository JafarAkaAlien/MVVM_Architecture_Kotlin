package com.leblebi.hbabamvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "users")
data class User(

    val avatar: String,
    val email: String,
    val first_name: String,
    @PrimaryKey (autoGenerate = false) val id: Int,
    val last_name: String
)