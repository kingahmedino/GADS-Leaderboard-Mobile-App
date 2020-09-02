package com.example.gadsleaderboardapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboardapp.R
import com.example.gadsleaderboardapp.databinding.LLeadersItemBinding
import com.example.gadsleaderboardapp.models.LearningLeader

class LearningLeadersAdapter(private val mLearningLeaders: List<LearningLeader>,
                             private val mContext: Context) :
        RecyclerView.Adapter<LearningLeadersAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding = DataBindingUtil.inflate<LLeadersItemBinding>(
            LayoutInflater.from(mContext), R.layout.l_leaders_item, parent, false)
        return BindingHolder(binding.root)
    }

    override fun getItemCount(): Int = mLearningLeaders.size

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val learningLeader = mLearningLeaders[position]
        holder.binding.learningLeader = learningLeader
        holder.binding.executePendingBindings()
    }

    class BindingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: LLeadersItemBinding = DataBindingUtil.bind(itemView)!!

    }

}