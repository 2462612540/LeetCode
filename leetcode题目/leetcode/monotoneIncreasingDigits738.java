/**
 * Copyright (C), 2018-2020
 * FileName: monotoneIncreasingDigits738
 * Author:   xjl
 * Date:     2020/8/14 21:48
 * Description: 738. 单调递增的数字
 */
package leetcode;

import org.junit.Test;

public class monotoneIncreasingDigits738 {
    public int monotoneIncreasingDigits(int N) {
        while (N > 0) {
            String number = new String(String.valueOf(N));
            int flag = 0;
            //遍历元素是否大于后一个元素
            for (int i = 1; i < number.length(); i++) {
                if (number.charAt(i) < number.charAt(i - 1)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return N;
            }
            N--;
        }
        return 0;
    }

    @Test
    public void test() {
        int i = monotoneIncreasingDigits(963856657);
        System.out.println(i);
    }
}
