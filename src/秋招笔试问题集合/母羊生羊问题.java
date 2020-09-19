/**
 * Copyright (C), 2018-2020
 * FileName: 母羊生羊问题
 * Author:   xjl
 * Date:     2020/9/17 13:59
 * Description:
 */
package 秋招笔试问题集合;

/**
 * 下一年的羊跟上一年的羊的年龄数有很大关系。
 *
 * 比如我们假设莫一年的羊1，2，3，4 岁的个数分别为  ： n1、n2、n3、n4.则下一年
 * n1′=n1+n3；
 * n2′=n1；
 * n3′=n2;
 * n4′=n3;
 *
 * 即后一年牛的总数为：2*n1+n2+2*n3.
 *
 */
public class 母羊生羊问题 {

    public static void main(String[] args) {
        int res = GetCow(16);
        System.out.println(res);
    }

    /**
     * 获取第n年羊的总数 表示 1 2 3 4 的所有的和的总数
     *
     * @param n
     * @return
     */
    public static int GetCow(int n) {
        return Get1Cow(n) + Get2Cow(n) + Get3Cow(n) + Get4Cow(n);
    }

    /**
     * 获取第n年1岁羊的个数
     *
     * @param n
     * @return
     */
    public static int Get1Cow(int n) {
        if (n <= 1) {
            return 1;
        }
        //获取前面一年的羊的数量 在1 岁的和3岁的羊
        return Get1Cow(n - 1) + Get3Cow(n - 1);
    }

    /**
     * 获取第n年2岁羊的个数
     *
     * @param n
     * @return
     */
    public static int Get2Cow(int n) {
        if (n <= 1) {
            return 0;
        }
        return Get1Cow(n - 1);
    }

    /**
     * 获取第n年3岁羊的个数
     *
     * @param n
     * @return
     */
    public static int Get3Cow(int n) {
        if (n <= 2) {
            return 0;
        }
        return Get2Cow(n - 1);
    }

    /**
     * 获取第n年4岁羊的个数
     *
     * @param n
     * @return
     */
    public static int Get4Cow(int n) {
        if (n <= 3) {
            return 0;
        }
        return Get3Cow(n - 1);
    }
}



