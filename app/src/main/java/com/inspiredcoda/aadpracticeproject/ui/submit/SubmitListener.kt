package com.inspiredcoda.aadpracticeproject.ui.submit

interface SubmitListener {

    fun onLoading()

    fun onSuccess()

    fun onFailure(message: String)

}