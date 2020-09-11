package com.inspiredcoda.aadpracticeproject.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inspiredcoda.aadpracticeproject.R
import com.inspiredcoda.aadpracticeproject.data.skill_id_leaders.SkillIQTops

class SkillAdapter(
    val skillTopers: SkillIQTops
): RecyclerView.Adapter<SkillAdapter.SkillsViewHolder>() {

    private val TAG = "SkillAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.skill_iq_layout, parent, false)
        return SkillsViewHolder(root)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        Glide.with(holder.image.context)
            .load(skillTopers[position].badgeUrl)
            .into(holder.image)

        holder.name.text = skillTopers[position].name
        holder.scoreAndLocation.text = "${skillTopers[position].score} Skill IQ Score, ${skillTopers[position].country}"

    }

    override fun getItemCount(): Int {
        Log.d(TAG, "${skillTopers.size}")
        return skillTopers.size
    }

    class SkillsViewHolder(root: View): RecyclerView.ViewHolder(root){
        val image = root.findViewById<ImageView>(R.id.badge_image)
        val name = root.findViewById<TextView>(R.id.skill_iq_name)
        val scoreAndLocation = root.findViewById<TextView>(R.id.skill_iq_score_and_location)
    }

}