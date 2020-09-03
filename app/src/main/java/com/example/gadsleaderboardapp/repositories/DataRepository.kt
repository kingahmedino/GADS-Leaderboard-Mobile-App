package com.example.gadsleaderboardapp.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.backend.BackendInterface
import com.example.gadsleaderboardapp.backend.BackendSubmitInterface
import com.example.gadsleaderboardapp.interfaces.RepoResponseListener
import com.example.gadsleaderboardapp.models.SkillIQLeader
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepository {
    var mRepoResponseListener: RepoResponseListener? = null

    fun getLearningLeaders() {
        val mutableLiveData = MutableLiveData<MutableList<LearningLeader>>()

        BackendInterface().getLearningLeaders()
            .enqueue(object : Callback<MutableList<LearningLeader>> {
                override fun onFailure(call: Call<MutableList<LearningLeader>>, t: Throwable) {
                    Log.d("Data Repository", "OnFailure: ${t.message}")
                    mRepoResponseListener?.onResponseFailure("Failure: ${t.message}")
                }

                override fun onResponse(
                    call: Call<MutableList<LearningLeader>>,
                    response: Response<MutableList<LearningLeader>>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.value = response.body()
                        Log.d("Data Repository", "Successful: ${mutableLiveData.value.toString()}")
                        mRepoResponseListener?.onLearningLeaderResponseSuccessful(mutableLiveData)
                    } else {
                        Log.d("Data Repository", "Unsuccessful: ${response.errorBody().toString()}")
                        mRepoResponseListener?.onSuccess(response.errorBody()?.string()!!)
                    }
                }
            })
    }

    fun getSkillIQLeaders() {
        val mutableLiveData = MutableLiveData<MutableList<SkillIQLeader>>()

        BackendInterface().getSkillIQLeaders()
            .enqueue(object : Callback<MutableList<SkillIQLeader>> {
                override fun onFailure(call: Call<MutableList<SkillIQLeader>>, t: Throwable) {
                    Log.d("Data Repository", "OnFailure: ${t.message}")
                    mRepoResponseListener?.onResponseFailure("Failure: ${t.message}")
                }

                override fun onResponse(
                    call: Call<MutableList<SkillIQLeader>>,
                    response: Response<MutableList<SkillIQLeader>>
                ) {
                    if (response.isSuccessful) {
                        mutableLiveData.value = response.body()
                        Log.d("Data Repository", "Successful: ${mutableLiveData.value.toString()}")
                        mRepoResponseListener?.onSkillIQLeaderResponseSuccessful(mutableLiveData)
                    }else{
                        Log.d("Data Repository", "Unsuccessful: ${response.errorBody().toString()}")
                        mRepoResponseListener?.onSuccess(response.errorBody()?.string()!!)
                    }
                }

            })
    }

    fun submitProject(email: String, firstName: String, lastName: String, projectLink: String) {
        val mutableLiveData = MutableLiveData<String>()

        BackendSubmitInterface().submitProject(email, firstName, lastName, projectLink)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("Submit Project", "Failure: ${t.message}")
                    mRepoResponseListener?.onResponseFailure(t.message!!)
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){
                        mutableLiveData.value = response.body()?.string()
                        Log.d("Submit Project", "Successful: ${mutableLiveData.value}")
                        mRepoResponseListener?.onSubmitProjectSuccess(mutableLiveData)
                    }else{
                        Log.d("Submit Project", "UnSuccessful: ${response.errorBody()?.string()}")
                        mRepoResponseListener?.onSuccess(response.errorBody()?.string()!!)
                    }
                }

            })
    }
}