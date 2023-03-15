package com.leblebi.hbabamvvm

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T:BaseViewModel>():AppCompatActivity() {
    abstract var viewModel :T
    open fun addObservers(){
        viewModel.problem.observe(this){
            Toast.makeText(this, "Problem occurred", Toast.LENGTH_SHORT).show()
        }
    }
    abstract fun addListeners()

    protected fun addListenerAndObservers(){
        addListeners()
        addObservers()
    }
}