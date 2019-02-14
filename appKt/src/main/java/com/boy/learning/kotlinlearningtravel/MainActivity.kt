package com.boy.learning.kotlinlearningtravel

import android.os.Bundle
import android.provider.Contacts
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.boy.learning.kotlinlearningtravel.javavskotlin.Student
import com.boy.learning.kotlinlearningtravel.javavskotlin.StudentKt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.*

/**
 * kotlin定位控件方式
 * 1.kt中使用xml中Id直接定位控件
 * 2.通过父布局id定位到子布局控件
 * kotlin点击事件
 * 1.匿名内部类
 * 2.全局实现OnClickListener接口
 * 3.When表达式(加强版的switch) 支持任意类型 支持纯表达式条件分支（类似于if）
 *
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG="MainActivity"
    // ?用来在变量声明出判断是否为null
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
        //类定义对比
        val xiaoming = StudentKt("小明",99)
        val xiaohong=xiaoming.copy(mName = "小红")
        Log.v(TAG," xiaoming 名字="+xiaoming.mName+",score="+xiaoming.mScore)
        Log.v(TAG," xiaohong 名字="+xiaohong.mName+",score="+xiaohong.mScore+xiaohong.toString())
        val xiaobai= Student("小白",100)
        Log.v(TAG," xiaobai 名字="+xiaobai.name+",score="+xiaobai.score+xiaobai.toString())





        //协程启动方式一

        Log.v(TAG," runCoroutineByFirstWay() start"+
                ",currentThreadName="+Thread.currentThread().name)
        runCoroutineByFirstWay()
        Log.v(TAG," runCoroutineByFirstWay() end")
        Log.v(TAG," runCoroutineBySecondWay() start")
        runCoroutineBySecondWay()
        Log.v(TAG," runCoroutineBySecondWay()() end")
        Log.v(TAG,"  runCoroutineByThirdWay() start")
        runCoroutineByThirdWay()
        Log.v(TAG,"  runCoroutineByThirdWay() end")


        Log.v(TAG,"  2 下一个数字是"+2.getNext())



    }




    /**
     * 用runBlocking方法进行协程启动的时候，当前线程被阻塞
     * 如果当前协程所在的线程被中断，那么意味着当前因为该协程运行导致的阻塞状态被打断
     * 那么就会抛出InterruptedException
     */
    private fun runCoroutineByFirstWay()= runBlocking {
        repeat(10) {
            Log.v(TAG, "Coroutine test runCoroutineByFirstWay() start$it"+
            ",currentThreadName="+Thread.currentThread().name)
            delay(52)
        }


    }

    /**
     * 用launch启动一个协程的时候，当前线程不会阻塞
     * 有点像轻量级线程了，用GlobalScope则代表这个协程生命周期
     * 跟应用进程是挂钩的，不受控制，所以一般不建议用。
     */
    private fun runCoroutineBySecondWay() {
        GlobalScope.launch(Dispatchers.IO, CoroutineStart.DEFAULT) {
            delay(1000L)
            Log.v(TAG, "Coroutine test runCoroutineBySecondWay() start"+
                    ",currentThreadName="+Thread.currentThread().name)
    }
    }

    /**
     * 首先用runBlocking开启一个异步的协程
     * 在该协程里面。Dispatchers.Default是一个默认的协程调度器是CoroutineContext的一种
     * 采用了lambda表达式，最后一个参数可以写在括号外面
     */
    private fun runCoroutineByThirdWay()= runBlocking {
        val job=async(Dispatchers.Default){
            delay(200)
            Log.v(TAG, "Coroutine test runCoroutineByThirdWay()"+
                    ",currentThreadName="+Thread.currentThread().name)
            return@async "hello i am runCoroutineByThirdWay()"
        }
        Log.v(TAG, job.await()+
                ",currentThreadName="+Thread.currentThread().name)
    }

    fun click3(v: View?) {
        when (v?.id) {
            R.id.btn_click3 ->
                Toast.makeText(this, btn_click3.text, Toast.LENGTH_SHORT).show()
        }
    }
}
