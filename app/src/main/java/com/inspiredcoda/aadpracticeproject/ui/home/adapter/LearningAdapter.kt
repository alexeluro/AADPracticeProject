package com.inspiredcoda.aadpracticeproject.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inspiredcoda.aadpracticeproject.R
import com.inspiredcoda.aadpracticeproject.data.learning_leaders.LearningLeaders

class LearningAdapter(
    val learningLeaders: LearningLeaders
): RecyclerView.Adapter<LearningAdapter.LearningViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.learning_leaders_layout, parent, false)
        return LearningViewHolder(root)
    }


    override fun onBindViewHolder(holder: LearningViewHolder, position: Int) {
        Glide.with(holder.image.context)
            .load(learningLeaders[position].badgeUrl)
            .into(holder.image)

        holder.name.text = learningLeaders[position].name
        holder.scoreAndLocation.text = "${learningLeaders[position].hours} learning hours, ${learningLeaders[position].country}"
    }

    override fun getItemCount(): Int {
        return learningLeaders.size
    }

    class LearningViewHolder(root: View): RecyclerView.ViewHolder(root){
        val image = root.findViewById<ImageView>(R.id.learner_img)
        val name = root.findViewById<TextView>(R.id.learning_leader_name)
        val scoreAndLocation = root.findViewById<TextView>(R.id.learning_leader_score_and_location)
    }

}