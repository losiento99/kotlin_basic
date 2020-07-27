package 基础知识
fun main(){
//testInterface()
//    testclass()


}
/**
 * 泛型函数
 */
//必须是一个数字一个字符串比较
fun <T:Number,R:String>compare(a:T,b:R):Boolean{
    return a==b
}

/**
 * 泛型约束 in out
 * in==?super
 * out==?extend
 */
fun test1(){
    var fathers:Array<Father> = emptyArray()
    var childs:Array<in Child> = emptyArray()
    childs=fathers

    var list:List<Father> = listOfNotNull(Father(),Child())
}


open class Father
class  Child:Father()

/**
 * 泛型接口
 */
//class Temp:OnClickListener<Button>{
//    override fun onClick(v: Button) {
//       println("${v.title}被电击了")
//    }
//
//}

fun testInterface(){
    val btn=Button("login")

    btn.listener=object :OnClickListener<Button>{
        override fun onClick(v: Button) {
            println("${v.title}被电击了")
        }
    }
    btn.userTouchDown()
}

interface OnClickListener<T>{
    fun  onClick(v:T)
}
class Button(var  title:String){
    var listener:OnClickListener<Button>?=null
    fun userTouchDown(){
        //有没有人要监听我的事件
        listener?.onClick(this)
        println("111")
    }
}
/**
 * 泛型类
 */
fun testclass(){
    var container =Container<Int>()
    container.add(10)
    container.add(20)

    container.get(0).also { println(it) }
}
class Container<T>{
    private var list:MutableList<T> = mutableListOf()
    fun add(e:T){
        list.add(e)
    }

    fun  get(index:Int):T{
        return list[index]
    }
    }

