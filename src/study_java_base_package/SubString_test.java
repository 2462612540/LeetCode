/**
 * Copyright (C), 2018-2020
 * FileName: SubString_test
 * Author:   xjl
 * Date:     2020/3/20 7:47
 * Description: 获取所有的子串的方法
 */
package study_java_base_package;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 获取所有的子串的方法
 */
public class SubString_test {
    public void SubString_test(String s){
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                System.out.println(s.substring(i,j+1));
            }
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    @Test
    public void  test(){
        lengthOfLongestSubstring2("abcbca");
    }
}
