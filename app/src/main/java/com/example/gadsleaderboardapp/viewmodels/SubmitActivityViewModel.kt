package com.example.gadsleaderboardapp.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.gadsleaderboardapp.interfaces.SubmitProjectListener
import com.example.gadsleaderboardapp.repositories.DataRepository

class SubmitActivityViewModel: ViewModel() {
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var projectLink: String? = null
    var mSubmitProjectListener: SubmitProjectListener? = null

    fun onSubmitButtonClick(view: View){
        if (email.isNullOrEmpty() || firstName.isNullOrEmpty() ||
            lastName.isNullOrEmpty() || projectLink.isNullOrEmpty()){
            mSubmitProjectListener?.onFailure()
            return
        }
        val mutableResponse = DataRepository.submitProject(email!!, firstName!!, lastName!!, projectLink!!)
        mSubmitProjectListener?.onSuccess(mutableResponse)
    }
}