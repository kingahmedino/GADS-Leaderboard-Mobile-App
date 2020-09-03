package com.example.gadsleaderboardapp.backend

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BackendSubmitInterface {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1824927963")email: String,
        @Field("entry.1877115667")firstName: String,
        @Field("entry.2006916086")lastName: String,
        @Field("entry.284483984")projectLink: String
    ): Call<ResponseBody>

    companion object{
        operator fun invoke(): BackendSubmitInterface{
            return Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BackendSubmitInterface::class.java)
        }
    }
}