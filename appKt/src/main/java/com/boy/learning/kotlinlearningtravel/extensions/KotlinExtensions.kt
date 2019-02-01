package com.boy.learning.kotlinlearningtravel.extensions

import com.boy.learning.kotlinlearningtravel.extensions.utils.CustomGetLenth
import com.boy.learning.kotlinlearningtravel.extensions.utils.StringUtils

/**
 * Kotlin 扩展
 */
fun main(args: Array<String>) {
    //-----------------------扩展函数(本kt文件)-------------------------------------
    Test1().temp()//输出结果-------------------------增加扩展函数-------------------------

    //-----------------------扩展函数(其他包下的kt文件)-------------------------------------
    val lenth = StringUtils().CustomGetLenth()
    println(lenth)//输出结果-------------------------11-------------------------

    //-----------------------范型化的扩展函数-------------------------------------

    Test2().temp(1)//输出结果-------------------------t is Int:1-------------------------
    Test2().temp("Boyi-Chen")//输出结果-------------------------t is String:Boyi-Chen-------------------------

    //-----------------------扩展函数不可覆盖（overriding）-------------------------------------
    val button: View = Button()
    button.longClick()//输出结果-------------------------base view longClicked-------------------------

    val button2: Button = Button()
    button2.longClick()//输出结果-------------------------button longClicked-------------------------
}


//-----------------------扩展函数(本类中扩展方法)-------------------------------------
//Test1：接收器类型（receiver type）
//this:  接收器对象（receiver object）
fun Test1.temp() {
    println("增加扩展函数,打印扩展类的属性name=${this.name}")
}

//-----------------------范型化的扩展函数-------------------------------------
fun <T> Test2.temp(t: T) {
    when (t) {
        is String -> println("t is String:$t")
        is Int -> println("t is Int:$t")
        else -> println("既不是String也不是Int")

    }
}

class Test1 {
    var name: String = "boyi.chen"
}

class Test2 {}

//-----------------------扩展函数不可覆盖（overriding）-------------------------------------
open class View {}

class Button : View() {}

fun View.longClick() = println("base view longClicked")
fun Button.longClick() = println("button longClicked")