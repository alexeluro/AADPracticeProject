package com.inspiredcoda.aadpracticeproject.util

import android.view.View
import android.widget.ProgressBar

fun String.isValidEmail(): Boolean{
    if (!this.contains("@")){
        return false
    }
    return true
}

fun ProgressBar.show(){
    this.visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    this.visibility = View.GONE
}