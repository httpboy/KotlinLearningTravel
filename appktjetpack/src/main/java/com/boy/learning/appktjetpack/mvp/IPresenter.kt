package com.boy.learning.appktjetpack.mvp

interface IPresenter {
    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}