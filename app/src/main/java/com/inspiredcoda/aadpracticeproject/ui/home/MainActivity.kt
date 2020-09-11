package com.inspiredcoda.aadpracticeproject.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.inspiredcoda.aadpracticeproject.R
import com.inspiredcoda.aadpracticeproject.ui.GadsPagerAdapter
import com.inspiredcoda.aadpracticeproject.ui.submit.SubmitActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tab_layout

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = tab_layout
        val viewPager = view_pager

        tabLayout.apply {
            addTab(tabLayout.newTab())
            addTab(tabLayout.newTab())
            tabGravity = TabLayout.GRAVITY_FILL
        }

        viewPager.apply {
            adapter = GadsPagerAdapter(supportFragmentManager, tabLayout.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        }

        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position!!
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

        })



    }



    fun proceedToSubmissionPage(view: View){
        Intent(this, SubmitActivity::class.java).also{
            startActivity(it)
        }
    }


}
