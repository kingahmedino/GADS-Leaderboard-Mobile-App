package com.example.gadsleaderboardapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.backend.BackendInterface
import com.example.gadsleaderboardapp.interfaces.RepoResponseListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepository {
    var mRepoResponseListener: RepoResponseListener? = null

    fun getLearningLeaders(){
        val mutableLiveData = MutableLiveData<MutableList<LearningLeader>>()

        BackendInterface().getLearningLeaders()
            .enqueue(object : Callback<MutableList<LearningLeader>> {
                override fun onFailure(call: Call<MutableList<LearningLeader>>, t: Throwable) {
                    Log.d("Data Repository", "OnFailure: ${t.message.toString()}")
                    mRepoResponseListener?.onResponseFailure("Failure: ${t.message.toString()}")
                }

                override fun onResponse(
                    call: Call<MutableList<LearningLeader>>,
                    response: Response<MutableList<LearningLeader>>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.value = response.body()
                        Log.d("Data Repository", "Successful: ${mutableLiveData.value.toString()}")
                        mRepoResponseListener?.onResponseSuccessful(mutableLiveData)
                    }else {
                        Log.d("Data Repository", "Unsuccessful: ${response.errorBody().toString()}")
                        mRepoResponseListener?.onSuccess(response.errorBody().toString())
                    }
                }
            })
    }
}