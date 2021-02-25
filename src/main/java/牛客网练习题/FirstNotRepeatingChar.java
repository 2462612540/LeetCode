/**
 * Copyright (C), 2018-2020
 * FileName: FirstNotRepeatingChar
 * Author:   xjl
 * Date:     2020/5/9 12:19
 * Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
package 牛客网练习题;

import org.junit.Test;

public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    count += 1;
                }
            }
            //只出现一次
            if (count == 1) {
                return i;
            } else {
                count = 0;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(FirstNotRepeatingChar("google"));
    }
}
