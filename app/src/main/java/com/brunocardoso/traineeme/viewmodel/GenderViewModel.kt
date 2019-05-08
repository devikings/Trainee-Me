package com.brunocardoso.traineeme.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.brunocardoso.traineeme.repository.GenderRepository
import com.brunocardoso.traineeme.repository.data.Gender

class GenderViewModel: ViewModel() {

    private var listGender = MutableLiveData<List<Gender>>()
    private var repository: GenderRepository? = null

    init {
        repository = GenderRepository.getInstance()

        repository?.let {

            listGender.postValue( it.listAll() )

        }
    }

    fun getListGender(): LiveData<List<Gender>> {
        return listGender
    }

}