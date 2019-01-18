package com.boy.learning.appktjetpack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boy.learning.appktjetpack.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_show_lifecycle.setOnClickListener {
            startActivity(Intent(this@MainActivity, LifecycleActivity::class.java))
        }

        btn_show_navigation.setOnClickListener {
            startActivity(Intent(this@MainActivity, NavigationActivity::class.java))

        }

    }
}
