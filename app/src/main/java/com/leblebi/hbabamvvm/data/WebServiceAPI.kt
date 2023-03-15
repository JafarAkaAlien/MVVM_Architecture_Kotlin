package com.leblebi.hbabamvvm.data

import com.leblebi.hbabamvvm.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServiceAPI {

    @GET ("api/users")
    suspend fun getAllUsers(@Query("page") page:Int , @Query("per_page") perPage:Int):Response<UsersResponse>

    @GET("api/{resources}")
    suspend fun getResources (@Path("resources") resources: String, @Query("page")page:Int, @Query("per_page")perPage:Int)


}