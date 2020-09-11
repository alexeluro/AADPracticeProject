package com.inspiredcoda.aadpracticeproject.data.learning_leaders


import com.google.gson.annotations.SerializedName

data class LearningLeadersItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("hours")
    val hours: Int,
    @SerializedName("name")
    val name: String
)