/**
 * Copyright (C), 2018-2020
 * FileName: isIsomorphic205
 * Author:   xjl
 * Date:     2020/8/25 9:35
 * Description: 痛殴字符串
 */
package Array;

import org.junit.Test;

import java.util.HashMap;

public class isIsomorphic205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                if (!map.containsKey(t.charAt(i))) {
                    map.put(t.charAt(i), s.charAt(i));
                } else {
                    if (s.charAt(i) != map.get(t.charAt(i))) {
                        return false;
                    } else {
                        continue;
                    }
                }
            } else {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s="egg",t="add";
        boolean isomorphic = isIsomorphic1(s,t)&&isIsomorphic1(t,s);
        System.out.println(isomorphic);
    }
}
