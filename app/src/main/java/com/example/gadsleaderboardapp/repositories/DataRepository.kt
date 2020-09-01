package com.example.gadsleaderboardapp.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.network.BackendInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {
    fun getLearningLeaders(name: String, hours: String,
                           country: String, badgeUrl: String): LiveData<LearningLeader>{
        val mutableLiveData = MutableLiveData<LearningLeader>()

        BackendInterface().getLearningLeaders(name, hours, country, badgeUrl)
            .enqueue(object: Callback<LearningLeader>{
                override fun onFailure(call: Call<LearningLeader>, t: Throwable) {
                    Log.d("Data Repository", "OnFailure: ${t.message.toString()}")
                }

                override fun onResponse(call: Call<LearningLeader>, response: Response<LearningLeader>) {
                    if (response.isSuccessful)
                        mutableLiveData.value = response.body()
                    else
                        Log.d("Data Repository", "Unsuccessful: ${response.errorBody().toString()}")
                }
            })
        return mutableLiveData
    }
}