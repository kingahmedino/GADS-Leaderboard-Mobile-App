package com.example.gadsleaderboardapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboardapp.R
import com.example.gadsleaderboardapp.databinding.SkillIqItemBinding
import com.example.gadsleaderboardapp.models.SkillIQLeader

class SkillIQLeadersAdapter(private val mSkillIQLeaders: MutableList<SkillIQLeader>,
                            private val mContext: Context) :
    RecyclerView.Adapter<SkillIQLeadersAdapter.BindingHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding = DataBindingUtil.inflate<SkillIqItemBinding>(
            LayoutInflater.from(mContext), R.layout.skill_iq_item, parent, false)
        return BindingHolder(binding.root)
    }

    override fun getItemCount(): Int = mSkillIQLeaders.size

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val skillIQLeader = mSkillIQLeaders[position]
        holder.binding.skillIQLeader = skillIQLeader
        holder.binding.executePendingBindings()
    }

    class BindingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: SkillIqItemBinding = DataBindingUtil.bind(itemView)!!
    }
}
