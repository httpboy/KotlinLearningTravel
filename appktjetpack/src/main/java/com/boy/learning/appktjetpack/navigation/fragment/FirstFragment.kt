package com.boy.learning.appktjetpack.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.boy.learning.appktjetpack.R
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.boy.learning.appktjetpack.mvp.impl.LoginPresenter


class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        lifecycle.addObserver(LoginPresenter(context!!))//在Fragment中添加观察者
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNext = view.findViewById<Button>(R.id.btn_next)
        btnNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_firstFragment_to_secondFragment);
        }
    }
}