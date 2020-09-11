package com.inspiredcoda.aadpracticeproject.ui.submit

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredcoda.aadpracticeproject.data.repository.SubmitRepository
import com.inspiredcoda.aadpracticeproject.util.ApiException
import com.inspiredcoda.aadpracticeproject.util.NoInternetException
import com.inspiredcoda.aadpracticeproject.util.isValidEmail
import kotlinx.coroutines.launch

class SubmitViewModel @ViewModelInject constructor(
    val repository: SubmitRepository
): ViewModel() {

    var listener: SubmitListener? = null

    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var gitHubLink: String? = null

    fun validateInputFields(): Boolean{
        if (firstName.isNullOrBlank()){
            listener?.onFailure("Input FirstName")
            return false
        }

        if (lastName.isNullOrBlank()){
            listener?.onFailure("Input LastName")
            return false
        }

        if (email.isNullOrBlank()){
            listener?.onFailure("Input Email")
            return false
        }

        if (email!!.isValidEmail()){
            listener?.onFailure("Input a valid email")
            return false
        }

        if (gitHubLink.isNullOrBlank()){
            listener?.onFailure("Input your GitHub Link")
            return false
        }

        return true
    }

    fun submitProject(){
        viewModelScope.launch {
            try {
                repository.submitProject(firstName!!, lastName!!, email!!, gitHubLink!!)
            }catch (e: ApiException){
                listener?.onFailure(e.message.toString())
            }catch (e: NoInternetException){
                listener?.onFailure(e.message.toString())
            }
        }
    }



}