package demo


import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.primaryConstructor

class Student
    (
    var sid:Int,
    var name:String,
    var address:String
)
@Entity class User(
    @ColumnInfo var id:Int,
    @ColumnInfo var name:String,
    @ColumnInfo var icon: String

){
    override fun toString(): String {
        return "User(id=$id,name='$name',icon='$icon')"
    }
}

//类注解
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Entity
//属性注解
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.PROPERTY)
annotation class ColumnInfo
//模拟数据的查询
fun selectData():Map<String,Map<String,Any>>{
    //模拟有俩哥表 User Student
    //使用map封装数据 k-v
    val userData = mapOf(
        Pair("id",1),
        Pair("name","jack"),
        Pair("icon","www,baidu.com"))
    val studentData= mapOf(
        Pair("sid",1),
        Pair("name","hsl"),
        Pair("address","chongqing"))
    val datas= mapOf(
        Pair("User",userData),
        Pair("Student",studentData))

    return datas
}
fun autoParseFromTable(modelClz: KClass<out Any>):Any?{
    //先从数据库里面读取出对应的数据
    val datas= selectData()
    //判断传递过来的KCLASS对象有没有Entity注解

  val entity= modelClz.findAnnotation<Entity>()

    if (entity==null){
        //传递过来的类 没有Entity注解
        //不能自动转换
        return "不能自动转换"

    }else {
        //这个类可以被自动转换
        //获取类名 --表名
        val tablename = modelClz.simpleName

        //使用这个表名去数据中获取这个表对应的数据
        val info = datas[tablename]
        //创建对象 再讲info的数据对应填充到对象的属性中
        //使用默认的主构造函数创建

        val constructor = modelClz.primaryConstructor

        //创建一个数组保存解析的属性的值
        //创建的数组元素个数和构造函数中参数的个数相同 初始值为null
        val params = arrayOfNulls<Any>(constructor?.parameters?.size!!)

        //遍历构造函数的参数
        constructor.parameters.forEach {
            //从数据源获取这个参数对应的值
            val value = info?.get(it.name)
            //将这个值保存到数组中
            params[it.index] = value

        }
        //调用构造函数 创建对象
        val obj = constructor?.call(*params)
        return obj
    }
}
fun main(){
 val user = autoParseFromTable(User::class) as User
    println(user.name)

    //val temp= arrayOf(10,20,30).toIntArray()
    //show(*temp)
}

//vararg 对应的是array类型的数组 不能是list
//fun show(vararg e:Int){
//    e.forEach { print(it) }
//}