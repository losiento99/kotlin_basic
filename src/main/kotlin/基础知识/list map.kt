package 基础知识

/**
 * kotlin 集合分可变 不可变
 * 接口 Collection <-MutableCollection
 * 子类
 *
 * list->MutableList
 * set->mutableSet
 * map->MutableMap
 */

fun main(){
//    val names:List<String?> =List(3){null}
//    val names2:List<String> = listOf()
//    val names3:List<String> = listOf("asd","areasd")
//    val names4:List<String> = emptyList()
//    names3.indexOf("asd").also { println(it) }
    val names1:MutableList<String?> =MutableList(3){null}
    val names2:MutableList<String> = mutableListOf()
    val names3:MutableList<String> = mutableListOf("asd","areasd")

    names3.listIterator().also {
        while (it.hasNext()) {

            it.next().also { item->if (item=="asd")it.remove() }

        }
    }
    for(item in names3){
        print(item)
    }

    map()
    MutableMap()
}


fun map(){
   //创建
    val dic = mapOf<String,String>()
    val dic2 =mapOf<String,String>(
        Pair("English","英文"),
        Pair("chinese","中文")
    )
    val dic3 = hashMapOf<String,String>()
    val dic4= hashMapOf<String,String>(
    Pair("English","英文"),
    Pair("chinese","中文")
    )

    val dic5 = linkedMapOf<String,String>()
    val dic6= linkedMapOf<String,String>(
        Pair("English","英文"),
        Pair("chinese","中文")
    )
    println(dic6.keys)
 dic6.forEach{
     println("${it.key}-- ${it.value}")
 }
}

fun MutableMap(){
    val names1= mutableMapOf<String,String>()
    val names2= mutableMapOf<String,String>(Pair(
        "tony","托尼大师"
    ))
    names2["老王"]="男人的痛"
    println(names2["tony"])
    println(names2)

}