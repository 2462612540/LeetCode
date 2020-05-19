/**
 * Copyright (C), 2018-2020
 * FileName: lastRemaining
 * Author:   xjl
 * Date:     2020/3/30 8:13
 * Description: 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环的问题
 */
public class lastRemaining {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;//计算的是删除的位置
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    @Test
    public void test() {
        System.out.println(lastRemaining(5, 3));
    }
}
