package com.boy.learning.appktjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boy.learning.appktjetpack.mvp.impl.LoginPresenter

/**
 *Lifecycle是Google推出的一系列的框架组件的其中一个，
 * 主要是用来感知Activity和Fragment的生命周期。
 * 演示：Lifecycle优雅的管理生命周期
 */
class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        lifecycle.addObserver(LoginPresenter(this))

    }

}