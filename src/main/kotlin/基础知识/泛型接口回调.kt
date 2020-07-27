package 基础知识

fun main() {
    val hsl = Boss()
    hsl.needHouse()

}

class Secret:RentHouse{
    override fun QQQ(content: String) {
        println("我是秘书 收到你的反馈了：$content 这房子不错")
    }

}

class Boss: RentHouse{
    override fun QQQ(content: String) {
        println("我是老板 收到你的反馈了：$content 这房子不错")
    }

    fun needHouse(){
        //找一个中介
        val agent = Agent()
        //告诉中介结果返回给谁
        //找个秘书
        //val xh = Secret()
        agent.listener = this
        //发起租房的事情
        agent.rentHouse()
    }
}

interface RentHouse{
    fun QQQ(content: String)
}

class Agent{
    //保存谁让我做事
    //记录做完事情之后 将结果回调给谁
    var listener:RentHouse? = null

    //实现具体的功能
    fun rentHouse(){
        println("开始找房.....")
        println("房子找到了")
        //回调
        listener?.QQQ("面朝大海 心暖花开")
    }
}