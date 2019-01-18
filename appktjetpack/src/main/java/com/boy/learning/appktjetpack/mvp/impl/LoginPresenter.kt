package com.boy.learning.appktjetpack.mvp.impl

import androidx.lifecycle.LifecycleObserver
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.boy.learning.appktjetpack.mvp.IPresenter

class LoginPresenter(context: Context) : IPresenter, LifecycleObserver {
    /**
     * 伴生对象定义静态常量
     */
    companion object {
        private const val LOGIN_PRESENTER = "login_presenter"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onCreate() {
        println("$LOGIN_PRESENTER->onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {
        println("$LOGIN_PRESENTER->onStart")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {
        println("$LOGIN_PRESENTER->onResume")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {
        println("$LOGIN_PRESENTER->onPause")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    override fun onStop() {
        println("$LOGIN_PRESENTER->onStop")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        println("$LOGIN_PRESENTER->onDestroy")

    }

}