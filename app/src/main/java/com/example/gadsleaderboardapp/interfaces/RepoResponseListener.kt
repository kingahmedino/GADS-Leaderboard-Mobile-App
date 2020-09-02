package com.example.gadsleaderboardapp.interfaces

import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.models.SkillIQLeader

interface RepoResponseListener {
    fun onSuccess(s: String)
    fun onLearningLeaderResponseSuccessful(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>)
    fun onSkillIQLeaderResponseSuccessful(skillIQLeaderResponse: MutableLiveData<MutableList<SkillIQLeader>>)
    fun onResponseFailure(s: String)
}