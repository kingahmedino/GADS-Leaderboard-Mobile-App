package com.example.gadsleaderboardapp.interfaces

import androidx.lifecycle.MutableLiveData

interface SubmitProjectListener {
    fun onSuccess(mutableLiveData: MutableLiveData<String>)
    fun onFailure(s: String)
}