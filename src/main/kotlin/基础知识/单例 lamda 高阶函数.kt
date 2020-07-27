package 基础知识



class person(var name:String){
}
var person.address:String
get() = "xxxxxx"
set(value)  {
    address=value
}
open class Shape
class Rectangle: Shape()
class Rectangle1: Shape()
fun Rectangle.getName() = "Shape"
fun Rectangle1.getName() = "Shape1"
fun Shape.getName() = "Rectangle"
fun printName(s: Shape){
    println(s.getName())
}
fun loadHomeData(id: Int): String {
    return "⽤户具体信息"
}
fun saveUserInfo(id: Int): String {
    return "保存⽤户成功"
}
var funC = { id: Int -> String
    println("加载主⻚数据")
   println("$id 加载成功。。。。数据")
}
var funD = { a:Int,b:Int -> Int
   println( a + b)
}
fun login(name: String,funParam:(Int)->String){
    //....登录
    val id = 1
    //进⼀步操作
    funParam(1).also {
        println(it)
    }
}
fun main(){

    //println(person("ad").address)
    // printName(Rectangle1())
//    var funA = ::loadHomeData
//    var funB= saveUserInfo(10)
//    funA(20).also { print(it) }
//    funB.also { print(it) }
//    saveUserInfo(10).also { print(it) }
//    (::saveUserInfo)(15).also { print(it) }
//    funC(2)
//    funD(1,3)
    login("asd") { id:Int-> String()
        "$ 是猪"
    }

}