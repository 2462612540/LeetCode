/**
 * Copyright (C), 2018-2020
 * FileName: LastRemain
 * Author:   xjl
 * Date:     2020/3/20 12:49
 * Description: 约瑟夫环问题
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 约瑟夫环的问题
 */
public class LastRemain {
    public int LastRemain(int n, int m) {
        //解决约瑟夫环的问题只要是利用是的链表的来模拟这个结果
        if (n == 0 || m == 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        //添加到列表中
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int removeindex = 0;
        while (list.size() != 1) {
            //这里是实现循环的删除和控制链表
            removeindex = (removeindex + m - 1) % list.size();
            list.remove(removeindex);
        }
        return list.get(0);
    }

    public int LastRemain2(int n, int m) {
//        f(n, m) = (f(n - 1, m) + m) % n;
//        f(1)=0;  f(2)=(f(1)+m)/2
        if (n == 0 || m == 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) / i;
        }
        return last;
    }

    @Test
    public void test() {
        System.out.println("flo".indexOf("flower"));
    }
}
