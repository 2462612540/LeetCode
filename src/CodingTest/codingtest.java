/**
 * Copyright (C), 2018-2020
 * FileName: codingtest
 * Author:   xjl
 * Date:     2020/5/7 15:25
 * Description: 测试
 */
package CodingTest;

import org.junit.Test;

public class codingtest {

    public int solution(int n) {
        int other=n;
        int sum = 0;
        int count = 1;
        int num = 0;
        while (n > 0) {
            n = n - count;
            count++;
        }
        count -= 1;
        for (int i = 1; i < count; i++) {
            sum += i * i;
        }
        for (int i = 0; i < count; i++) {
            num += i;
        }
        sum += count * (other - num);
        return sum;
    }

    @Test
    public void test() {
        int re = solution(4);
        System.out.println(re);
    }
}
