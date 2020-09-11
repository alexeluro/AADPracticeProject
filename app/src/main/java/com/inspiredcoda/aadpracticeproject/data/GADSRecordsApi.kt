package com.inspiredcoda.aadpracticeproject.data

import com.inspiredcoda.aadpracticeproject.data.learning_leaders.LearningLeaders
import com.inspiredcoda.aadpracticeproject.data.skill_id_leaders.SkillIQTops
import retrofit2.Response
import retrofit2.http.GET

interface GADSRecordsApi {

    @GET("api/skilliq")
    suspend fun getSkillIq(): Response<SkillIQTops>

    @GET("api/hours")
    suspend fun getLearningLeaders(): Response<LearningLeaders>

}