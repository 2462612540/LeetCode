/**
 * Copyright (C), 2018-2020
 * FileName: numWaterBottles1518
 * Author:   xjl
 * Date:     2020/8/3 10:07
 * Description: 1518. 换酒问题
 */
package leetcode;

public class numWaterBottles1518 {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = numWaterBottles(9, 3);
        System.out.println(i);
    }

}
