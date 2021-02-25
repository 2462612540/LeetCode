/**
 * Copyright (C), 2018-2020
 * FileName: 最大公共字串
 * Author:   xjl
 * Date:     2020/9/14 16:33
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 最大公共字串 {

    @Test
    public void test() {
        String s = GetCommon("abccade", "dgcadde");
        System.out.println(s);
    }

    public String GetCommon(String s1, String s2) {
        int left = 0;
        int right = Math.min(s1.length(), s2.length());
        while (right > left) {
            int mid = left + (right - left) / 2;
            String test = test11(s1, s2, mid);
            if ("".equals(test)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if ("".equals(test11(s1, s2, right))) {
            return test11(s1, s2, right - 1);
        }
        return test11(s1, s2, right);
    }

    private String test11(String s1, String s2, int n) {
        Map<String ,Integer> map=new HashMap<>();
        for (int i=0;i<s1.length()-n;i++){
            map.put(s1.substring(i,i+n),1);
        }
        for (int i=0;i<s2.length()-n;i++){
            if(map.get(s2.substring(i,i+n))!=null){
                return s2.substring(i,i+n);
            }
        }
        return "";
    }
}
