package com.example.gadsleaderboardapp.network

import com.example.gadsleaderboardapp.fragments.LearningLeadersFragment
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

interface BackendInterface {
    @FormUrlEncoded
    @GET("api/hours")
    fun getLearningLeaders(
        @Field("name") name: String,
        @Field("hours") hours: String,
        @Field("country") country: String,
        @Field("badgeUrl") badgeUrl: String
    ): Call<LearningLeadersFragment>

    companion object{
        operator fun invoke(): BackendInterface{
            return Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BackendInterface::class.java)
        }
    }
}