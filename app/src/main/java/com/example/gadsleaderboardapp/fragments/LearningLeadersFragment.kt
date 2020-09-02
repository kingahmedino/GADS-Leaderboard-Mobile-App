package com.example.gadsleaderboardapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboardapp.R
import com.example.gadsleaderboardapp.interfaces.RepoResponseListener
import com.example.gadsleaderboardapp.interfaces.ViewModelResponseListener
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.viewmodels.LeadersViewModel

class LearningLeadersFragment : Fragment(), ViewModelResponseListener {
    private var leadersViewModel: LeadersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(this).get(LeadersViewModel::class.java)
        leadersViewModel!!.mViewModelResponseListener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leadersViewModel?.returnLearningLeaders()
    }

    override fun onSuccess(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>) {
        learningLeaderResponse.observe(this, Observer {
            Toast.makeText(context, "${it.size}", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onFailure(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }

}