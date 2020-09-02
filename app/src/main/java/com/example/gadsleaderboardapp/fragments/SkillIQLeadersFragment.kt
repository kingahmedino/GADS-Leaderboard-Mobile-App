package com.example.gadsleaderboardapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboardapp.R
import com.example.gadsleaderboardapp.databinding.FragmentSkillIqLeadersBinding
import com.example.gadsleaderboardapp.interfaces.ViewModelResponseListener
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.models.SkillIQLeader
import com.example.gadsleaderboardapp.viewmodels.LeadersViewModel

class SkillIQLeadersFragment : Fragment(), ViewModelResponseListener {
    private var leadersViewModel: LeadersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(this).get(LeadersViewModel::class.java)
        leadersViewModel!!.mViewModelResponseListener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val mBinding = FragmentSkillIqLeadersBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leadersViewModel?.returnSkillIQLeaders()
    }

    override fun onLearningLeaderSuccess(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>) {

    }

    override fun onSkillIQLeaderSuccess(skillIQLeaderResponse: MutableLiveData<MutableList<SkillIQLeader>>) {
        skillIQLeaderResponse.observe(this, Observer {
            Toast.makeText(context, "${it.size}", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onFailure(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }

}