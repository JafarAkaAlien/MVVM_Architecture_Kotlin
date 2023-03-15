package com.leblebi.hbabamvvm

import android.content.Context
import com.leblebi.hbabamvvm.data.WebServiceAPI
import com.leblebi.hbabamvvm.data.local.MyRoomDatabase
import com.leblebi.hbabamvvm.utils.RetrofitInstance


abstract class BaseRepository {


    protected fun httpExecute():WebServiceAPI =   RetrofitInstance.INSTANCE.create(WebServiceAPI::class.java)

    protected fun getRoom (context: Context) = MyRoomDatabase.getInstance(context)


}