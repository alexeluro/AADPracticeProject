package com.inspiredcoda.aadpracticeproject.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.inspiredcoda.aadpracticeproject.R
import com.inspiredcoda.aadpracticeproject.ui.home.adapter.SkillAdapter
import com.inspiredcoda.aadpracticeproject.util.hide
import com.inspiredcoda.aadpracticeproject.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_skill_i_q_leaders.*

/**
 * A simple [Fragment] subclass.
 */
@AndroidEntryPoint
class SkillIQLeadersFragment : Fragment(), HomeListener {

    private val TAG = "SkillIQFragment"
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false)
    }


    private fun observer(){
        homeViewModel.getSkillIqTopsLive.observe(viewLifecycleOwner, Observer {
            initRecyclerView(SkillAdapter(it))
        })
    }

    private fun initRecyclerView(skillAdapter: SkillAdapter){
        Log.d(TAG, "Initialized RecyclerView....................")
        skill_recycler_view.apply {
            adapter = skillAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.listener = this

        homeViewModel.setSkillLeaders()

        observer()
    }

    override fun onLoading() {
        skill_iq_progress.show()
    }

    override fun onSuccess() {
        skill_iq_progress.hide()
    }

    override fun onFailure(message: String) {
        skill_iq_progress.hide()
    }

}
