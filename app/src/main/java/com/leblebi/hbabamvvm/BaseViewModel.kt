package com.leblebi.hbabamvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected val _problem = MutableLiveData<Boolean>()
    val problem:LiveData<Boolean> = _problem
}