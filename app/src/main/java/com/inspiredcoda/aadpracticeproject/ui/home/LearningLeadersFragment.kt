package com.inspiredcoda.aadpracticeproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.inspiredcoda.aadpracticeproject.R
import com.inspiredcoda.aadpracticeproject.ui.home.adapter.LearningAdapter
import com.inspiredcoda.aadpracticeproject.util.hide
import com.inspiredcoda.aadpracticeproject.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_learning_leaders.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class LearningLeadersFragment : Fragment(), HomeListener {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    private fun observer(){
        homeViewModel.getLearningLeadersLive.observe(
            viewLifecycleOwner, Observer {
                initRecyclerView(LearningAdapter(it))
            }
        )

    }

    private fun initRecyclerView(learningAdapter: LearningAdapter){
        learning_leaders_recycler_view.apply {
            adapter = learningAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.listener = this

        homeViewModel.setLeaders()

        observer()
    }

    override fun onLoading() {
        learning_leader_progress.show()
    }

    override fun onSuccess() {
        learning_leader_progress.hide()
    }

    override fun onFailure(message: String) {
        learning_leader_progress.hide()
    }


}
