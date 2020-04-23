/**
 * Copyright (C), 2018-2020
 * FileName: test
 * Author:   xjl
 * Date:     2020/3/20 7:41
 * Description: 阿里测试
 */
package AlibabbaTest;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class test {
    //返回最长的字符创的长度
    public int test2(int n, String s1, String s2, String s3, String s4) {
        String result = s1 + s2 + s3 + s4;
        System.out.print(result);
        System.out.println(result.length());
        Set<Character> set = new TreeSet<>();
        for (int i = 0; i < result.length(); i++) {
            if (!set.contains(result.charAt(i))) {
                set.add(result.charAt(i));
            }
        }
        for (char value : set) {
            System.out.print(value);
        }
        System.out.println(set.size());
        return 0;
    }

    @Test
    public void test() {
        int n = 4;
        String s1 = "rstuvw";
        String s3 = "abcdefgh";
        String s2 = "opq";
        String s4 = "abcdefghijk";
        test2(n, s1, s2, s3, s4);
    }
}
