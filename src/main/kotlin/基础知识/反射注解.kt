package 基础知识

import kotlin.reflect.KClass

fun main(){

test()
  //  test2()
}
/**
 反射和注解
 在程序运行过程中动态地调用类的属性和方法
 字节码文件kotlin（kclass) java(class)
 1.如何获取字节码文件类型
 */

//调用方法属性
fun test(){
    //只知道这个类
    val clz=Person::class
    //知道类的对象
    val xw =Person()
    val clz2=xw.javaClass.kotlin

    clz.constructors.forEach{ println(it)}

}
open class Father1(){
    val address:String ="asdasd"
    fun test1(){

    }
}
class Person:Father1(){
    var name:String="xw"
    fun show(){
        println("1111")
    }

}
//通过kclass创建对象
fun test2(){
   //获取类对象
    //将 Person.Kclass->Any->Person
    //val xw= createObj(Person::class)as Person
  //println(xw.name)
    invokeFun(Person::class,"show")

}
//调用函数
fun invokeFun(clz:KClass<out Any>,funNmae:String){

}
//创建对象
fun createObj(clz:KClass<out Any>):Any{
    //1使用默认的构造函数
    return 0
}

//生命周期
@Retention(AnnotationRetention.RUNTIME)
//注解作用在哪里
@Target(AnnotationTarget.CLASS)
//注解里面参数只能用val
annotation class Tablename(val name:String)
@Tablename(name = "TTT") class TTT{}