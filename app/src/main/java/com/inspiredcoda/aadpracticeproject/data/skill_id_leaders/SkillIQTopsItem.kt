package com.inspiredcoda.aadpracticeproject.data.skill_id_leaders


import com.google.gson.annotations.SerializedName

data class SkillIQTopsItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int
)