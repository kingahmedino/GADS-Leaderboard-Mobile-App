package com.example.gadsleaderboardapp.interfaces

import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader

interface RepoResponseListener {
    fun onSuccess(s: String)
    fun onResponseSuccessful(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>)
    fun onResponseFailure(s: String)
}