/**
 * Copyright (C), 2018-2020
 * FileName: codingtest2020050716
 * Author:   xjl
 * Date:     2020/5/7 16:34
 * Description: 测试代码
 */
package CodingTest;

import org.junit.Test;

public class codingtest2020050716 {

    int solution(int n) {
        if (n < 10) return 10 + n;
        int res = 0, base = 1;
        for (int i = 9; i > 1; i--) {
            while (n % i == 0) {
                res += i * base;
                base *= 10;
                n /= i;
            }
        }
        if (n > 1) return -1;
        else return res;
    }

    @Test
    public void test() {
        System.out.println(solution(36));
    }

}
