package com.inspiredcoda.aadpracticeproject.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspiredcoda.aadpracticeproject.data.GADSRecordsApi
import com.inspiredcoda.aadpracticeproject.data.learning_leaders.LearningLeaders
import com.inspiredcoda.aadpracticeproject.data.repository.HomeRepository
import com.inspiredcoda.aadpracticeproject.data.skill_id_leaders.SkillIQTops
import kotlinx.coroutines.launch


class HomeViewModel @ViewModelInject constructor(
    val repository: HomeRepository
): ViewModel() {

    var listener: HomeListener? = null

    private var _learningLeaders = MutableLiveData<LearningLeaders>()

    private var _skillIqLeaders = MutableLiveData<SkillIQTops>()

    val getLearningLeadersLive: LiveData<LearningLeaders>
        get() = _learningLeaders

    val getSkillIqTopsLive: LiveData<SkillIQTops>
        get() = _skillIqLeaders

    fun setLeaders(){
        listener?.onLoading()
        viewModelScope.launch {
            _learningLeaders.value = repository.getLearningLeaders()
            listener?.onSuccess()
        }
    }

    fun setSkillLeaders(){
        listener?.onLoading()
        viewModelScope.launch {
            _skillIqLeaders.value = repository.getSkillIqLeaders()
            listener?.onSuccess()
        }
    }

//    fun getLearningLeaders(): LiveData<LearningLeaders>{
//        return getLearningLeadersLive
//    }

//    fun getSkillIqLeaders(): LiveData<SkillIQTops>{
//        return getSkillIqTopsLive
//    }


}