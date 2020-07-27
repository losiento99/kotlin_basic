package 基础知识

import java.util.*

fun main() {
    class Person(val name: String, var age: Int) {
    }

    var xw = Person("asd", 123)
    xw.name
    xw.age = 12

    //主构造⽅法
    class Student() {
        //次构造⽅法 必须调⽤主构造函数
        constructor(name: String) : this() {

        }

        //次构造⽅法 必须调⽤主构造函数
        constructor(name: String, age: Int) : this() {

        }
    }

    val zs1 = Student()
    val zs2 = Student("zs")
    val zs3 = Student("zs", 20)

    class Game(var name: String) {
        val level = 0.also { println("$name de level is $it") }

        init {
            println("初始化角色")
        }

        constructor(name: String, age: Int) : this(name) {
            println("正在构造角色")
        }
    }
    //var xl =Game("小李",12)
    // var xx=Game("xx",12)
    // println(xx)

    //提供默认值
    class Car(var wheels: Int = 4, var color: String = "⽩⾊") {
        //重写toString⽅法
        override fun toString(): String {
            return "Car(wheels=$wheels, color='$color')"
        }

    }

    val audi1 = Car() //可以不传值
    //println(audi1)
    val audi2 = Car(3) //设置⼀个值 另外⼀个⽤默认值
    //println(audi2)

    class Person1 {
        val age: Int = 20 //内、外部只能读 ⽆法更改
        var name: String = "JackChen" //内部可读可写 外部只能读
            get() = field.toUpperCase()
            set(value) {
                field = if (value.contains("swu")) "⻄南⼤学" else "不知名的学校"
            }
    }
  //  println("${Person1().age}+${Person1().name}")

    class Person2{
        var wife: String ? = null //可能为空

        fun show(){
            println("哥哥结婚了 媳妇⼉是：$wife")
            val len = wife?.length //如果为空不执⾏后⾯操作 不空则执⾏
          val len2 = wife!!.length //强制说wife肯定不为空

            len.let { println(len) }
        }
    }
    //Person2().show()

val abc:String by lazy { "大街上" }
   lateinit var bbb:String
    fun set(){
        bbb="123"
    }


    //showList("www.baidu.com")
    //实例化再实现
   // val btn=Buttonlistener()
    //didTouch(btn)
    //简洁方式
   // Buttonlistener().also { didTouch(it) }

    //匿名类
//    didTouch(object: OnTouchListener{
//        override fun onTouchEvent(type: String) {
//            println("接收到事件为： $type")
//        }
//    })



//    QQQ().show()
//    BBB().show1()
//   var  btn=onttevent()
//    ddtouchlisten1(btn)
//    onttevent().also { ddtouchlisten1(it) }

    LoginActivity("1123")

}



//fun showList(url: String){
//    fun load(): String{
//        return "${url}下载完毕"
//    }
//
//    fun loadList(){
//        load().also {
//            println(it)
//            println("开始展示数据")
//        }
//    }
//    loadList()
//
//}
//class  bank(){
//    var money:Money = Money(1000)
//    class  Money(var num:Int){
//    fun pp1(){
//
//    }
//    }
//inner  class person(){
//fun save( count:Int){
//money.num+=count
//}
//
//}
//
//}
//interface OnTouchListener{
//    fun onTouchEvent(type: String)
//}
//fun didTouch(listener: OnTouchListener ){
//    listener.onTouchEvent("⼿指按下")
//}
//class Buttonlistener :OnTouchListener{
//    override fun onTouchEvent(type: String) {
//        println("接受到的事件为$type")
//    }
//
//}
class QQQ{
    fun show(){
        dispatchTouch(object : OnTouchListener{
            override fun onTouchEvent(type: String) {
                println("接收到事件为： $type")
            }
        })
    }
    fun dispatchTouch(listener: OnTouchListener){
        listener.onTouchEvent("⼿指在滑动")
    }
    interface OnTouchListener{
        fun onTouchEvent(type: String)
    }
}
class BBB() {
    fun diontouchlisten(lis: ontouchlisten) {
        lis.ontouch("hsl")
    }

    fun show1() {
        diontouchlisten(object : ontouchlisten {
            override fun ontouch(tt: String) {
                println("大帅比是:    $tt")
            }
        })
    }


    interface ontouchlisten{
        fun ontouch(tt: String)

    }
}
class onttevent:ontouchlisten1 {
    override fun dd(d: String) {
    println("大刷币是 $d")
    }
}

fun ddtouchlisten1(liss:ontouchlisten1){
    liss.dd("zzzz")
}

interface ontouchlisten1{
    fun dd(d:String)
}

//抽象类默认是open的
abstract class BaseActivity{
    //抽象属性不能初始化
    abstract var title:String
    init {
        //创建界⾯
      //  实现抽象类
        onCreate()
        //暂停界⾯
        onPause()
        //销毁⻚⾯
        onDestory()
    }
    //抽象⽅法不能实现
    abstract fun onCreate()
    //如果要重写抽象类的普通⽅法 必须使⽤open来修饰这个⽅法
    open fun onPause(){
    }
    open fun onDestory(){
    }
}
class LoginActivity(override var title: String) : BaseActivity(){
    override fun onCreate() {
        println("登录界⾯被创建了")
    }
    override fun onPause() {
        super.onPause()
        println("界⾯暂停了")
    }
    override fun onDestory() {
        super.onDestory()
        println("界⾯消失了")
    }
}
class MainActivity(override var title: String) : BaseActivity() {
    override fun onCreate() {
        println("主⻚界⾯被创建了")
    }
}