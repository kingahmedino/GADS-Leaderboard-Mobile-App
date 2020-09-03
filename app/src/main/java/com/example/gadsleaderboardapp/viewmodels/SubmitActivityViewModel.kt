package com.example.gadsleaderboardapp.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gadsleaderboardapp.interfaces.RepoResponseListener
import com.example.gadsleaderboardapp.interfaces.SubmitProjectListener
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.models.SkillIQLeader
import com.example.gadsleaderboardapp.repositories.DataRepository

class SubmitActivityViewModel: ViewModel(), RepoResponseListener {
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var projectLink: String? = null
    var mSubmitProjectListener: SubmitProjectListener? = null

    fun onSubmitButtonClick(view: View){
        if (email.isNullOrEmpty() || firstName.isNullOrEmpty() ||
            lastName.isNullOrEmpty() || projectLink.isNullOrEmpty()){
            mSubmitProjectListener?.onFailure("Check that all fields are filled")
            return
        }
        DataRepository.mRepoResponseListener = this
        DataRepository.submitProject(email!!, firstName!!, lastName!!, projectLink!!)
    }

    override fun onSubmitProjectSuccess(mutableLiveData: MutableLiveData<String>) {
        mSubmitProjectListener?.onSuccess(mutableLiveData)
    }

    override fun onSuccess(s: String) {
        mSubmitProjectListener?.onFailure(s)
    }

    override fun onResponseFailure(s: String) {
        mSubmitProjectListener?.onFailure(s)
    }

    override fun onLearningLeaderResponseSuccessful(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>) {

    }

    override fun onSkillIQLeaderResponseSuccessful(skillIQLeaderResponse: MutableLiveData<MutableList<SkillIQLeader>>) {

    }
}