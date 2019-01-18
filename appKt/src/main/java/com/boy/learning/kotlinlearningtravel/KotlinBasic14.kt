package com.lucky.kotlin.luckykotlinlearning


/**
 * Kotlin 泛型
 */
fun main(args: Array<String>) {
    //-----------------------泛型类-------------------------------------
    //泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上。
    // 与 Java 一样，Kotlin 也提供泛型，为类型安全提供保证，消除类型强转的烦恼。
    Box<Int>(12306).A()//12306
    Box<String>("12306").A()//12306
    Box("12306").A()//12306


    //-----------------------泛型函数-------------------------------------

    boxIn<Int>(666).A()//666
    boxIn(666).A()//666
    doPrintType("string")// string:String
    doPrintType(777)//777:INT
    doPrintType(true)//true:other

    //-----------------------泛型约束-------------------------------------
    //我们可以使用泛型约束来设定一个给定参数允许使用的类型
    //Kotlin 中使用 : 对泛型的的类型上限进行约束
    //最常见的约束是上界(upper bound)
    ExtendsBase2(ExtendsBase1()).doTfun()//ExtendsBase1.fun1

    //-----------------------型变-------------------------------------
    //声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
    //使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型：
    val r = R1("BOYI.CHEN")
    //in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型：


}

class Box<T>(t: T) {
    var name = t
    fun A() {
        println(name)
    }
}

fun <T> boxIn(value: T) = Box(value)

fun <T> doPrintType(content: T) {
    when (content) {
        is Int -> println("$content:INT")
        is String -> println("$content:String")
        else -> println("$content:other")
    }
}

open class Base1 {
    open fun fun1() {}
}

open class Base2 {
    open fun fun1() {}
}

class ExtendsBase1 : Base1() {
    override fun fun1() {
        println("ExtendsBase1.fun1")
    }

}

class ExtendsBase2<T : Base1>(tClass: T) {
    private var temp = tClass

    fun doTfun() {
        temp.fun1()
    }
}

class R1<out A>(val name: A) {
    fun doR(): A {
        return name
    }

}