package 基础知识
fun main(){
    val names=Array<String>(3){"$it-str"
    }
    for(i in names.indices){
 //       println(names[i])
    }
    for(str in names){
  //      println(str)
    }
    for((i,str)in names.withIndex()){
  //      println(str)
    }
//使用iterator来遍历数组
    //val iterator=names.iterator()
  //  while(iterator.hasNext()){
    //    println(iterator.next())
    names.iterator().also {it.next().also { println(it) }  }

    names.iterator().also { iterator ->iterator.next().also{ println(it)}  }

    names.iterator().also { while(it.hasNext()){
        println(it.next())}
    }

    }

