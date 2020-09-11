package com.inspiredcoda.aadpracticeproject.data.repository

import com.inspiredcoda.aadpracticeproject.data.GADSSubmit
import com.inspiredcoda.aadpracticeproject.data.SafeApiRequest
import javax.inject.Inject

class SubmitRepository @Inject constructor(
    val submitApi: GADSSubmit
): SafeApiRequest() {


    suspend fun submitProject(firstName: String, lastName: String, email: String, gitHubLink: String){
        apiRequest { submitApi.submitProject(firstName, lastName, email, gitHubLink) }
    }


}