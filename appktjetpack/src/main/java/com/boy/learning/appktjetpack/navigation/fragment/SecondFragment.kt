package com.boy.learning.appktjetpack.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.boy.learning.appktjetpack.R
import com.boy.learning.appktjetpack.mvp.impl.LoginPresenter
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_back.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
}