package com.example.gadsleaderboardapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gadsleaderboardapp.R
import com.example.gadsleaderboardapp.adapters.LearningLeadersAdapter
import com.example.gadsleaderboardapp.databinding.FragmentLearningLeadersBinding
import com.example.gadsleaderboardapp.interfaces.RepoResponseListener
import com.example.gadsleaderboardapp.interfaces.ViewModelResponseListener
import com.example.gadsleaderboardapp.models.LearningLeader
import com.example.gadsleaderboardapp.models.SkillIQLeader
import com.example.gadsleaderboardapp.viewmodels.LeadersViewModel
import kotlinx.android.synthetic.main.fragment_learning_leaders.*

class LearningLeadersFragment : Fragment(), ViewModelResponseListener {
    lateinit var mBinding: FragmentLearningLeadersBinding
    private var leadersViewModel: LeadersViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leadersViewModel = ViewModelProvider(this).get(LeadersViewModel::class.java)
        leadersViewModel!!.mViewModelResponseListener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLearningLeadersBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leadersViewModel?.returnLearningLeaders()
    }

    override fun onLearningLeaderSuccess(learningLeaderResponse: MutableLiveData<MutableList<LearningLeader>>) {
        learningLeaderResponse.observe(this, Observer { leaders ->
            learning_leaders_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                it.setHasFixedSize(true)
                it.adapter = LearningLeadersAdapter(leaders, requireContext())

            }
        })
    }

    override fun onSkillIQLeaderSuccess(skillIQLeaderResponse: MutableLiveData<MutableList<SkillIQLeader>>) {

    }

    override fun onFailure(s: String) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }

}