package com.example.gadsleaderboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.gadsleaderboardapp.adapters.ViewPagerAdapter
import com.example.gadsleaderboardapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager){ tab, position ->
            if (position == 0)
                tab.text = "Learning Leaders"
            else
                tab.text = "Skill IQ Leaders"
        }.attach()
    }
}