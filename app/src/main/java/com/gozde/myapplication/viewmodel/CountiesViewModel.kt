package com.gozde.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gozde.myapplication.model.BaseResponse
import com.gozde.myapplication.model.CountryResult
import com.gozde.myapplication.model.DataHolder
import com.gozde.myapplication.repository.CoronaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountiesViewModel @Inject constructor( private val repository: CoronaRepository) : ViewModel() {
    val liveCountries = MutableLiveData<DataHolder<BaseResponse>>()

    fun getCountriesData(){
        viewModelScope.launch {
            val response = repository.getCountriesData()
            liveCountries.postValue(response)
        }
    }
}