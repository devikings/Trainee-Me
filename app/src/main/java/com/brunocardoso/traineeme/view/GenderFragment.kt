package com.brunocardoso.traineeme.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.brunocardoso.traineeme.R
import com.brunocardoso.traineeme.viewmodel.GenderViewModel

class GenderFragment : Fragment() {

    private lateinit var genderViewModel: GenderViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?)
            : View? {

        return inflater.inflate(R.layout.fragment_gender, container, false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        genderViewModel = ViewModelProviders.of(this).get(GenderViewModel::class.java)
        genderViewModel.getListGender().observe(this, Observer {

        })

    }

}
