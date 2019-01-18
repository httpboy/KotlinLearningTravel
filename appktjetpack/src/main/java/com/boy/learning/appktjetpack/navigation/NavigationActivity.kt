package com.boy.learning.appktjetpack.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.boy.learning.appktjetpack.R

/**
 * 演示：优雅的使用Fragment
 *
 *
 * 在传统的单Activity多Fragment场景中，
 * 我们往往需要为Activity添加一个FrameLayout作为Fragment的容器
 *
 *XML中定义的Navigation中HavHostFragment就是Fragment的容器。
 *布局中的navGraph属性建立了与navigation资源文件的关系
 */
class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
    }

    override fun onSupportNavigateUp(): Boolean {
        val fragment = supportFragmentManager.findFragmentById(R.id.navigation_containers)
//        val fragment = navigation_containers
        return NavHostFragment.findNavController(fragment!!).navigateUp()
    }

}