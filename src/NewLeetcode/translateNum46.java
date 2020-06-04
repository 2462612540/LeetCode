/**
 * Copyright (C), 2018-2020
 * FileName: translateNum46
 * Author:   xjl
 * Date:     2020/6/4 10:07
 * Description: 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package NewLeetcode;

import org.junit.Test;

public class translateNum46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

    @Test
    public void test() {
        int count = translateNum(12258);
        System.out.println(count);
    }
}
