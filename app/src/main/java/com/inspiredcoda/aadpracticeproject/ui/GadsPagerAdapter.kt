package com.inspiredcoda.aadpracticeproject.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.inspiredcoda.aadpracticeproject.ui.home.LearningLeadersFragment
import com.inspiredcoda.aadpracticeproject.ui.home.SkillIQLeadersFragment

class GadsPagerAdapter(
    val fragmentManager: FragmentManager,
    val tabCount: Int
): FragmentPagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> LearningLeadersFragment()
            1 -> SkillIQLeadersFragment()
            else -> LearningLeadersFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Learning Leaders"
            1 -> "Skill IQ Leaders"
            else -> "Learning Leaders"
        }
    }

    override fun getCount(): Int {
        return tabCount
    }


}