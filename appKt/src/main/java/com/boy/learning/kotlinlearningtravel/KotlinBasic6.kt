package com.lucky.kotlin.luckykotlinlearning


/**
 * 1.Kotlin 基本数据类型 Byte Short Int Long Float Double 字符不属于数值类型，是一个独立的数据类型
 * 2.类型转换
 * 3.位操作符
 * 4.字符
 * 5.布尔
 * 6.数组
 * 7.字符串
 * 8.字符串模板
 */
fun main(args: Array<String>) {
    var a: Int = 128
    println(a === a)//true
    var b: Int? = a
    var c: Int? = a
    println(b == c)//true
    println(b === c)//如果 a<128 false,a>=128 true 长话短说，JVM把[-128,127]的所有int数字全部缓存了，任何指向这个范围的对象，都不可能被另外"创建"，又何谈“装箱”


    val x: Byte = 1
    //val y: Int = b // 转化错误
    val y: Int = x.toInt()
    println(y)//1
    //-----------------------自动类型转化-------------------------------------
    val temp = 10L + 3 // Long + Int => Long
    println(temp)
    //-----------------------位操作符-------------------------------------
    //左移
    var shlShow = 1.shl(2)
    println(shlShow)//输出4
    //右移
    var shrShow = 4.shr(2)
    println(shrShow)//输出1
    //-----------------------字符-------------------------------------
    var ch: Char = 'a'
    println(ch)//输出a
    var chToInt: Int = ch.toInt()
    println(chToInt)//输出97
    //-----------------------布尔-------------------------------------
    var bl: Boolean = false
    println(bl)//输出false
    //-----------------------数组-------------------------------------
    var arrs = arrayOf(1, 2, 3, 0, 6)
    for (arr in arrs) {
        print("$arr,")//输出1,2,3,0,6,
    }
    println()
    var arrs2 = Array(3) { i -> (i * 2) }
    for (arr in arrs2) {
        print("$arr,")//输出0,2,4,
    }
    println()

    val z: IntArray = intArrayOf(1, 2, 3)
    z[0] = z[1] + z[2]
    println(z[0])//输出5
    //-----------------------字符串-------------------------------------
    var strs: String = "12306"
    for (s in strs) {
        print("$s,")//输出1,2,3,0,6,
    }
    println()

    var text = """666
        |777
        |999
        |""".trimMargin()//前置空格删除
    println(text) //输出666/n777/n999
    println(text.length) //输出12
    //-----------------------字符串模板-------------------------------------

    val i = 12306
    val s = "i = $i" // 输出i = 12306
    println(s)

    val s2 = "I am boyi.chen"
    val str = "$s2.length is ${s2.length}"
    println(str)//输出 I am boyi.chen.length is 14

    var price = "$9.99"
    println(price)//$9.99

}
