package demo

import java.util.*

fun main() {
    println("*****欢迎来到ATM系统*****")
    var password=666666
    var money=10000//定义初始化的钱
    println("*****请输入密码*****")

    for(i in 1..3){
        val input  = Scanner(System.`in`)
        var pw=input.nextInt()
        if(pw!=password){
            println("密码错误请重新输入")
        }
        else{
            println("密码正确")
            break;
        }
    }
    println("**请进行操作选择**")
    println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
    loop@while(true){
        val input  = Scanner(System.`in`)
        var xuanze=input.nextInt()
        when(xuanze){
            1 -> {

                while(true) {
                    println("**请把钱存入存款机**")

                    var money1=input.nextInt()

                    println("**你所存的金额为 $money1 请确认：1.确认2.错误**")
                    var select = input.nextInt()
                    if (select == 1) {
                        money=money+money1
                        println("存款成功 你当前所剩余额为$money")
                        println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
                        break
                    }else{
                        println("存款失败，请取回钱重新操作")
                        println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
                        break
                    }
                }
            }
            2 -> {
                while(true) {
                    println("**请输入取款金额**")
                    var money2=input.nextInt()

                    println("**你所取的金额为 $money2 请确认：1.确认2.错误**")
                    var select = input.nextInt()
                    if (select == 1) {
                        money=money-money2
                        println("取款成功 你当前所剩余额为$money")
                        println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
                        break
                    }else{
                        println("取款失败，请联系工作人员")
                        println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
                        break
                    }
                }

            }
            3 -> {
                println("你当前余额为$money")
                println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
            }
            4-> {
                println("请输入原密码")
                for(i in 1..3){
                    var pw=input.nextInt()
                    if(pw!=password){
                        println("密码错误请重新输入")
                    }
                    else{
                        println("密码正确")
                        println("请输入新密码")
                        var pw2=input.nextInt()
                        println("请确认新密码")
                        var pw3=input.nextInt()
                        if (pw2==pw3){
                            password=pw2
                            println("修改成功")
                        }else{
                            println("新密码不一致")
                            println("修改失败")
                        }
                        break;
                    }
                }
                println("**1.存款**2.取款**3.查询余额**4.改密**5.退出**")
            }
            5->{
                println("退出成功")
                break@loop
            }
            else->{
                println("请输入正确选择")
            }
        }
    }


}
