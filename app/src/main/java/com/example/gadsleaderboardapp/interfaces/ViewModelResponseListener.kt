package com.example.gadsleaderboardapp.interfaces

import androidx.lifecycle.MutableLiveData
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.models.SkillIQLeader

interface ViewModelResponseListener {
    fun onLearningLeaderSuccess(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>)
    fun onSkillIQLeaderSuccess(skillIQLeaderResponse: MutableLiveData<MutableList<SkillIQLeader>>)
    fun onFailure(s: String)
}