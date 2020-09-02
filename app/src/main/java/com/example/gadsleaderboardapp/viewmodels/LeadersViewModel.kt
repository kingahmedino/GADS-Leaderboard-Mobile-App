package com.example.gadsleaderboardapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gadsleaderboardapp.interfaces.RepoResponseListener
import com.example.gadsleaderboardapp.interfaces.ViewModelResponseListener
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.models.SkillIQLeader
import com.example.gadsleaderboardapp.repositories.DataRepository

class LeadersViewModel: ViewModel(), RepoResponseListener {
    var mViewModelResponseListener: ViewModelResponseListener? = null

    fun returnLearningLeaders(){
        DataRepository.mRepoResponseListener = this
        DataRepository.getLearningLeaders()
    }

    fun returnSkillIQLeaders(){
        DataRepository.mRepoResponseListener = this
        DataRepository.getSkillIQLeaders()
    }

    override fun onSuccess(s: String) {
        mViewModelResponseListener?.onFailure(s)
    }

    override fun onLearningLeaderResponseSuccessful(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>) {
        mViewModelResponseListener?.onLearningLeaderSuccess(learningLeaderResponse)
    }

    override fun onSkillIQLeaderResponseSuccessful(skillIQLeaderResponse: MutableLiveData<MutableList<SkillIQLeader>>) {
        mViewModelResponseListener?.onSkillIQLeaderSuccess(skillIQLeaderResponse)
    }

    override fun onResponseFailure(s: String) {
        mViewModelResponseListener?.onFailure(s)
    }
}