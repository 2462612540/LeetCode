/**
 * Copyright (C), 2018-2020
 * FileName: test
 * Author:   xjl
 * Date:     2020/3/20 7:41
 * Description: 阿里测试
 */
package AlibabbaTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    public int test2(int n, String s1, String s2, String s3, String s4) {
        Map<Character, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        Map<Character, Integer> map3 = new HashMap();

        map1.put(s1.charAt(0), 1);
        map2.put(s2.length(), 1);
        map3.put(s3.charAt(s1.length()-1), 1);


        return 0;
    }

    @Test
    public void test() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1);
        System.out.println(str2);;
        System.out.println(str1==str2);//基本啥类型数据是比较的是数值 但是如果是西对象的话那么比较的是地址
        System.out.println(str1.equals(str2));//这个是比较的是地址
    }
}
