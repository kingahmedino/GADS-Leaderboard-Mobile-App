package com.example.gadsleaderboardapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gadsleaderboardapp.fragments.LearningLeadersFragment
import com.example.gadsleaderboardapp.fragments.SkillIQLeadersFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            LearningLeadersFragment()
        else
            SkillIQLeadersFragment()
    }
}