package com.inspiredcoda.aadpracticeproject.ui.submit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.inspiredcoda.aadpracticeproject.R
import com.inspiredcoda.aadpracticeproject.util.hide
import com.inspiredcoda.aadpracticeproject.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_submit.*

@AndroidEntryPoint
class SubmitActivity : AppCompatActivity(), SubmitListener {

    private val submitViewModel: SubmitViewModel by viewModels()

    private lateinit var successDialog: AlertDialog
    private lateinit var failureDialog: AlertDialog
    private lateinit var questionDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        submitViewModel.listener = this

        prepareSuccessDialog()
        prepareFailureDialog()
        prepareQuestionDialog()

    }

    private fun prepareSuccessDialog(){
        successDialog = AlertDialog.Builder(this)
            .setView(R.layout.error_dialog)
            .setCancelable(true)
            .create()
    }

    private fun prepareFailureDialog(){
        failureDialog = AlertDialog.Builder(this)
            .setView(R.layout.error_dialog)
            .setCancelable(true)
            .create()
    }

    private fun prepareQuestionDialog(){
        val root = layoutInflater.inflate(R.layout.question_dialog, null)
        root.findViewById<Button>(R.id.question_positive_btn).setOnClickListener {
            onBackPressed()
        }
        root.findViewById<ImageView>(R.id.question_cancel_icon).setOnClickListener {
            questionDialog.dismiss()
        }
        questionDialog = AlertDialog.Builder(this)
            .setView(root)
            .setCancelable(false)
            .create()
    }

    fun submitProject(view: View){
        submitViewModel.firstName = first_name.text.toString()
        submitViewModel.lastName = last_name.text.toString()
        submitViewModel.email = email.text.toString()
        submitViewModel.gitHubLink = github_link.text.toString()

        if(submitViewModel.validateInputFields()){
            submitViewModel.submitProject()
        }
    }

    fun backButton(view: View){
        showQuestionDialog()
    }

    private fun showFailureDialog(){
        failureDialog.show()
    }

    private fun showSuccessDialog(){
        successDialog.show()
    }

    private fun showQuestionDialog(){
        questionDialog.show()
    }

    override fun onLoading() {
        submit_progress.show()
    }

    override fun onSuccess() {
        submit_progress.hide()
        showSuccessDialog()
    }

    override fun onFailure(message: String) {
        submit_progress.hide()
        showFailureDialog()
    }

}
