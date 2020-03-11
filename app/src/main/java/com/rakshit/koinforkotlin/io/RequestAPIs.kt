package com.rakshit.koinforkotlin.io

import io.reactivex.Single
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RequestAPIs {

    @FormUrlEncoded
    @POST("login")
    fun login(@FieldMap params: MutableMap<String, String>): Single<String>
}
