package com.inspiredcoda.aadpracticeproject.data.repository

import com.inspiredcoda.aadpracticeproject.data.GADSRecordsApi
import com.inspiredcoda.aadpracticeproject.data.SafeApiRequest
import com.inspiredcoda.aadpracticeproject.data.learning_leaders.LearningLeaders
import com.inspiredcoda.aadpracticeproject.data.skill_id_leaders.SkillIQTops
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class HomeRepository @Inject constructor(
    val recordsApi: GADSRecordsApi
): SafeApiRequest() {


    suspend fun getLearningLeaders(): LearningLeaders{
        return apiRequest { recordsApi.getLearningLeaders() }
    }

    suspend fun getSkillIqLeaders(): SkillIQTops{
        return apiRequest { recordsApi.getSkillIq() }
    }



}