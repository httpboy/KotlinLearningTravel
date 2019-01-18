package com.lucky.kotlin.luckykotlinlearning


/**
 * Kotlin 类和对象
 * 1.类定义
 * 2.类的属性
 * 3.主构造器
 * 4.次构造函数
 * 5.抽象类
 * 6.嵌套类
 * 7.内部类
 * 8.匿名内部类
 * 9.类的修饰符
 */
fun main(args: Array<String>) {
    //-----------------------类定义-------------------------------------

    val hello = Hello()
    println(hello.name + ":" + hello.age)//输出 boyi.chen:100

    val hello2 = Hello2()
    println(hello2.name + ":" + hello2.age)//输出 BOYI.CHEN:100
    hello2.name = "我想改变名字"
    println(hello2.name + ":" + hello2.age)//输出 不能改名字，你应该输入BOYI.CHEN:100

    //如果hello对象没初始话
    //报错kotlin.UninitializedPropertyAccessException: lateinit property hello has not been initialized
    //输出 不能改名字，你应该输入BOYI.CHEN:100:100
    hello2.setup()
    println(hello2.name + ":" + hello2.age + ":" + hello2.hello.age)//不能改名字，你应该输入BOYI.CHEN:100

    //-----------------------主构造器-------------------------------------
    //如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数
    val student = Student("boyi.chen")//输出 name is boyi.chen
    Student("boyi.chen", 666)//输出 name is boyi.chen /n name is boyi.chen : age is 666
    Student2()//name is
    Student2("boyi.chen")//name is boyi.chen

    //-----------------------嵌套类 -------------------------------------
    println(Outer.Inner().age)//999

    //-----------------------内部类-------------------------------------
    println(Outer2().Inner2().temp)//boyi.chen
    println(Outer2().Inner2().objects.name2)//boyi.chen2

    //-----------------------匿名内部类-------------------------------------
    val test = Test()//输出 接口定义的方法在匿名内部类中实现
    test.setOnClickListener(object : OnClickListener {
        override fun test() {
            println("接口定义的方法在匿名内部类中实现")
        }
    })


    //----------------------- 类的修饰符-------------------------------------
    //类属性修饰符
//    abstract    // 抽象类
//    final       // 类不可继承，默认属性
//    enum        // 枚举类
//    open        // 类可继承，类默认是final的
//    annotation  // 注解类
    //访问权限修饰符
//    private    // 仅在同一个文件中可见
//    protected  // 同一个文件中或子类可见
//    public     // 所有调用的地方都可见
//    internal   // 同一个模块中可见

}

class Hello {
    var name: String = "boyi.chen"
    var age: Int = 100
    fun sayHello() {
        println("hello kotlin")
    }
}

class Hello2() {
    var name: String = "boyi.chen"
        get() = field.toUpperCase()
        set(value) {
            if (value == "我想改变名字") {
                field = "不能改名字，你应该输入boyi.chen"
            }
        }
    var age: Int = 100
    //非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit
    lateinit var hello: Hello

    fun setup() {
        hello = Hello()
    }
}

//-----------------------次构造函数-------------------------------------
class Student constructor(name: String) {
    constructor(name: String, age: Int) : this(name) {
        println("name is $name : age is $age")
    }

    init {
        println("name is $name")
    }
}

//在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，
// 编译器会生成一个附加的无参的构造函数，这个构造函数会
// 直接使用默认值。这使得 Kotlin 可以更简单的使用像
// Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库
class Student2(val name: String = "") {
    init {
        println("name is $name")
    }
}

//-----------------------抽象类-------------------------------------
//抽象是面向对象编程的特征之一，类本身，或类中的部分成员，
//都可以声明为abstract的。抽象成员在类中不存在具体的实现。
//注意：无需对抽象类或抽象成员标注open注解。
open class Base {
    open fun f() {}
}

abstract class extendsBase : Base() {
    abstract override fun f()
}

//-----------------------抽象类-------------------------------------
class Outer {
    private val name: String = "boyi.chen"

    class Inner {
        val age: Int = 999

    }
}

//-----------------------内部类-------------------------------------
//内部类使用 inner 关键字来表示
//内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
//要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签
class Outer2 {
    private val name: String = "boyi.chen"
    val name2: String = "boyi.chen2"

    inner class Inner2 {
        val temp: String = name
        val objects = this@Outer2
    }
}
//-----------------------匿名内部类-------------------------------------

class Test {
    var v = "匿名内部类"

    fun setOnClickListener(test: OnClickListener) {
        test.test()
    }

}

interface OnClickListener {
    fun test()
}




