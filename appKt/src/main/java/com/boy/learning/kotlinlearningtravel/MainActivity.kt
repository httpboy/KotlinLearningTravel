package com.boy.learning.kotlinlearningtravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * kotlin定位控件方式
 * 1.kt中使用xml中Id直接定位控件
 * 2.通过父布局id定位到子布局控件
 * kotlin点击事件
 * 1.匿名内部类
 * 2.全局实现OnClickListener接口
 * 3.When表达式(加强版的switch) 支持任意类型 支持纯表达式条件分支（类似于if）
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_click ->
                Toast.makeText(this, btn_click.text, Toast.LENGTH_LONG).show()
            R.id.btn_click2 ->
                Toast.makeText(this, btn_click2.text, Toast.LENGTH_LONG).show()
            else ->
                Toast.makeText(this, "你点击的是什么鬼", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_show.text = "定位控件方式1：kotlin告別找ID方式"
        ll_content.tv_show2.text = "定位控件方式2：kotlin告別找ID方式"
        btn_click.setOnClickListener {
            Toast.makeText(this, btn_click.text, Toast.LENGTH_LONG).show()
        }

        btn_click2.setOnClickListener(this)


    }

    fun click3(v: View?) {
        when (v?.id) {
            R.id.btn_click3 ->
                Toast.makeText(this, btn_click3.text, Toast.LENGTH_SHORT).show()
        }
    }
}
