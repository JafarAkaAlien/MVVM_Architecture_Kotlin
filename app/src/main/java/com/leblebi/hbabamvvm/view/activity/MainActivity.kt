package com.leblebi.hbabamvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.leblebi.hbabamvvm.BaseActivity
import com.leblebi.hbabamvvm.R
import com.leblebi.hbabamvvm.model.User
import com.leblebi.hbabamvvm.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity<MainActivityViewModel>() {

    private lateinit var usersRecyclerView: RecyclerView
    override lateinit var viewModel:MainActivityViewModel
     override fun addObservers() {
        super.addObservers()
        viewModel.remoteUsers.observe(this){

        }
        viewModel.getAllUsers().observe(this){

        }
    }

    override fun addListeners() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //usersRecyclerView.adapter
        setContentView(R.layout.activity_main)
        viewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]
        addListenerAndObservers()
    }

    private fun getAllRemoteUser(){
        viewModel.getAllRometeUsers(0,3)
    }

    private fun saveUser(user:User){
        viewModel.saveUser(user)
    }
}