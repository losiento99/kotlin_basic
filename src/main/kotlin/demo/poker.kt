package demo

import java.util.*
/**
1.输入参与人数
1.1输入每局消耗的金币
2.编号 取名字 给初始金币
3.生成一副牌
4.发牌
5.显示牌
 */
fun main() {
    var b: Int = 0
    var d: Int = 0
    var i: Int = 0
    println("*****欢迎来到扑克大赛*****")
    println("**请输入参与人数以及底注**")
    var input = Scanner(System.`in`)
    var number = input.nextInt()
    var dizhumoney = input.nextInt()
    var TotalMoney:Int=0
    var  zhumoney = dizhumoney
    TotalMoney=dizhumoney*number

    var playerid: MutableList<Int> = mutableListOf()
    var playername: MutableList<String> = mutableListOf()
    var playermoney: MutableList<Int> = mutableListOf()
    var qipaiplayerid: MutableList<Int> = mutableListOf()
    var firstplayermoney: MutableList<Int> = mutableListOf()

    var pokernumber: MutableList<String> = mutableListOf()
    var pokertype: MutableList<String> = mutableListOf()
    var pokernumberbijiao: MutableList<Int> = mutableListOf()
    var pokertypebijiao: MutableList<Int> = mutableListOf()
    println("**依次输入玩家id，名字，本金**")
    for (i in 1..number) {
        var id = input.nextInt()
        var name = input.next()
        var money = input.nextInt()
        money=money-zhumoney


        var poker1 = Random().nextInt(13)
        var poker2 = Random().nextInt(4)
        playerid.add(id)
        playername.add(name)
        playermoney.add(money)
        firstplayermoney.add(money)


        when (poker2) {
            3 -> {
                pokertype.add("♠")
                pokertypebijiao.add(3)
            }
            2 -> {
                pokertype.add("♥")
                pokertypebijiao.add(2)
            }
            1 -> {
                pokertype.add("♣")
                pokertypebijiao.add(1)
            }
            0 -> {
                pokertype.add("♦")
                pokertypebijiao.add(0)
            }
        }
        when (poker1) {
            1 -> {
                pokernumber.add("A")
                pokernumberbijiao.add(1)
            }
            11 -> {
                pokernumber.add("J")
                pokernumberbijiao.add(11)
            }
            12 -> {
                pokernumber.add("Q")
                pokernumberbijiao.add(12)
            }
            0 -> {
                pokernumber.add("K")
                pokernumberbijiao.add(13)
            }
            else -> {
                pokernumber.add((poker1.toString()))
                pokernumberbijiao.add(poker1)

            }
        }

    }


    //比较牌
    fun qipai(a: Int) {
        println("${playerid[a]} 号玩家弃牌了")
        playermoney[i] = playermoney[i] - zhumoney
        TotalMoney=zhumoney+TotalMoney
        println("${playerid[a]} 号玩家所剩金额为 ${playermoney[i]}")
        qipaiplayerid.add(playerid[a])
        playerid.removeAt(a)
        playername.removeAt(a)
        playermoney.removeAt(a)
        firstplayermoney.removeAt(a)
        pokernumber.removeAt(a)
        pokertype.removeAt(a)
        pokernumberbijiao.removeAt(a)
        pokertypebijiao.removeAt(a)
        b++
        println("弃牌玩家id为:$qipaiplayerid")
    }

    //与他人比较时定位准
    fun dingwei(a: Int) {
        for (c in qipaiplayerid) {
            if (a > c) {
                //几个弃牌了
                d++
            }
        }
    }

    while (true) {


        if (b < number-1 ) {
            //初始化为0
            d=0
            println("**${playerid[i]} 号玩家进行选择**")
            println("*****1.看牌以及弃牌 2.跟牌或者加注 3.与玩家比较 *****")
            var xuanze1 = input.nextInt()
            when (xuanze1) {
                1 -> {

                    println("${playerid[i]} 号玩家 ${playername[i]} 牌为 ${pokertype[i]} ${pokernumber[i]}")
                    println("是否弃牌:1.是 2.否")
                    var xuanze2 = input.nextInt()
                    if (xuanze2 == 1) {

                        qipai(i)

                    } else {

                    }
                }
                2 -> {
                    if (playermoney[i] > zhumoney) {
                        println("请选择跟牌还是加注:1.跟牌 2.加注")
                        var xuanze3 = input.nextInt()
                        if (xuanze3 == 1) {
                            playermoney[i] = playermoney[i] - zhumoney
                            TotalMoney+=TotalMoney+zhumoney
                            println("${playerid[i]} 号玩家所剩金额为 ${playermoney[i]}")
                            if (i == number - 1 - b) {
                                i = 0
                            } else {
                                i++

                            }

                        } else {
                            println("输入要加注的金额")
                            var jiazhumoney = input.nextInt()
                            var zhumoney = jiazhumoney + zhumoney
                            playermoney[i] = playermoney[i] - zhumoney
                            TotalMoney+=TotalMoney+zhumoney
                            println("${playerid[i]} 号玩家所剩金额为 ${playermoney[i]}")

                            if (i == number - b - 1) {
                                i = 0
                            } else {
                                i++
                            }
                        }
                    } else {
                        println("余额不足，只能弃牌")
                        qipai(i)
                    }


                }
                3 -> {

                    println("请输入被比较玩家的id")

                    var id = input.nextInt()
                    dingwei(id)
                    if (pokernumberbijiao[i] < pokernumberbijiao[id-d-1]) {
//当前玩家弃牌
                        qipai(i)
                        //被比较的在后面
                        if(i<(id-d-1)){

                        }else{
                            //被比较的在前面同时比较的在最后一位
                            if(i+b==number){
                                i=0
                            }
                        }

                    }else if(pokernumberbijiao[i] > pokernumberbijiao[id - d - 1])
                    {
                        id - d - 1+d
                        qipai(id - d - 1)
                        //被弃牌的在后面 i++
                        if(i<(id-d-1)){
                            //在最后面
                            if(id==number){
                                i=0
                            }else{
                                i++
                            }

                        }else{
                            //被弃牌的在前面同时比较的在最后一位
                            if(i+b==number){
                                i=0
                            }
                        }
                    }else if(pokernumberbijiao[i] == pokernumberbijiao[id - d - 1])
                    {
                        if (pokertypebijiao[i] <= pokertypebijiao[id - d - 1]) {
//当前玩家弃牌
                            qipai(i)
                            if(i<(id-d-1)){

                            }else{
                                //被比较的在前面同时比较的在最后一位
                                if(i+b==number){
                                    i=0
                                }
                            }
                        } else {
//被比较的玩家弃牌

                            qipai(id - d - 1)
                            if(i<(id-d-1)){
                                if(id==number){
                                    i=0
                                }else{
                                    i++
                                }
                            }else{
                                //被弃牌的在前面同时比较的在最后一位
                                if(i+b==number){
                                    i=0
                                }
                            }
                        }
                    }
                }
                else -> {
                    println("请输入正确选择")
                }
            }

        } else {
            println("${playerid[i]} 号玩家${playername[i]} 获胜了 一共赚了${playermoney[i] +TotalMoney- firstplayermoney[i]}")
            break
        }

    }

}


