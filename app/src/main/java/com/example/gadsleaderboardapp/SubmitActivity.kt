package com.example.gadsleaderboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gadsleaderboardapp.databinding.ActivitySubmitBinding
import com.example.gadsleaderboardapp.databinding.AlertDialogBinding
import com.example.gadsleaderboardapp.databinding.ResponseDialogBinding
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

    override fun onStarted() {
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
        val binding = AlertDialogBinding.bind(dialogView)

        val builder: AlertDialog = AlertDialog.Builder(this).create()
        builder.setView(dialogView)
        builder.show()

        binding.button.setOnClickListener {
            builder.dismiss()
            mBinding.viewModel?.continueWithRequest()
        }
    }

    override fun onSuccess(mutableLiveData: MutableLiveData<String>) {
        createResponseDialog(R.drawable.ic_baseline_check_circle, "Submission Successful")
    }

    override fun onFailure(s: String) {
        createResponseDialog(R.drawable.ic_baseline_report_problem_24, "Submission Unsuccessful")
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun createResponseDialog(res: Int, s: String) {
        val dialog = layoutInflater.inflate(R.layout.response_dialog, null)
        val binding = ResponseDialogBinding.bind(dialog)

        val builder: AlertDialog = AlertDialog.Builder(this).create()
        builder.setView(dialog)
        builder.show()

        binding.submissionResponse.text = s
        binding.img.setImageResource(res)
    }
}