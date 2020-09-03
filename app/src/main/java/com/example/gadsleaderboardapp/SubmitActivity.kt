package com.example.gadsleaderboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboardapp.databinding.ActivitySubmitBinding
import com.example.gadsleaderboardapp.interfaces.SubmitProjectListener
import com.example.gadsleaderboardapp.viewmodels.SubmitActivityViewModel
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitActivity : AppCompatActivity(), SubmitProjectListener {
    lateinit var mBinding: ActivitySubmitBinding
    lateinit var mSubmitViewModel: SubmitActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_submit)
        mSubmitViewModel = ViewModelProvider(this).get(SubmitActivityViewModel::class.java)

        mBinding.viewModel = mSubmitViewModel
        mSubmitViewModel.mSubmitProjectListener = this

        setSupportActionBar(toolbar)
        toolbarWorks()
    }

    private fun toolbarWorks() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onSuccess(mutableLiveData: MutableLiveData<String>) {
        mutableLiveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onFailure(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}