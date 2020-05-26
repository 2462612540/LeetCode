/**
 * Copyright (C), 2018-2020
 * FileName: test1
 * Author:   xjl
 * Date:     2020/5/6 13:26
 * Description: 测试练习1
 */
package leetcode;

import org.junit.Test;

public class test1 {
    public int test1(int n) {
        int count=0;
        while (n>0){
            n=n-count;
            count++;
        }
        count-=1;
        //这个时候的count就是值

        return count-1;
    }

    @Test
    public void test() {
        System.out.println(test1(11));
    }
}
