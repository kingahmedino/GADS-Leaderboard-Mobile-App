package com.example.gadsleaderboardapp.interfaces

import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader

interface ViewModelResponseListener {
    fun onSuccess(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>)
    fun onFailure(s: String)
}