/**
 * Copyright (C), 2018-2020
 * FileName: shenxinfu_Big_data
 * Author:   xjl
 * Date:     2020/6/16 9:44
 * Description: 深信服大数据测试
 */
package CodingTest;

public class shenxinfu_Big_data {
    /**
     * 第一个题目：
     * 一个平面上 从（0,0）能否走到（18,18）表示的是
     * F L
     * F 为1 表示x正 F 为-1 表示的x的负
     * F 为2 表示y正 F 为-2 表示的y的负
     * <p>
     * 注意玩偶一旦超过了轨道就不能继续移动了
     * <p>
     * 4
     * 1 2
     * 2 0 (表示任意的移动的距离至少为1)
     * 1 4
     * 1 12
     */
    public void test1() {

    }

    /**
     * 第二个题目：
     * 输入五个集合 求解的是每一个集合的中选择一个数据之和加起来等于是2018 如果是存在的话表示的
     * 2
     * -----------------------------
     * 2
     * 0 1
     * -5 300
     * -202 402
     * 5 5
     * -----------------------------
     */

    public void test2() {
        //输入五个数据

        //求解

        //返回结果
    }

    /**
     * 第三题目：给定一个正整数 问能否有多个 2 5 7 相乘得到 如果可以表示的返回为1 如果不行范围为0
     */

    public int test3(int N) {
        if (N < 2) {
            return 0;
        }
        while (N % 2 == 0)
            N /= 2;
        while (N % 3 == 0)
            N /= 3;
        while (N % 5 == 0)
            N /= 5;
        if (N == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
