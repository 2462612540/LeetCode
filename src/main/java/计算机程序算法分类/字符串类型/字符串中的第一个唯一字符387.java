package 计算机程序算法分类.字符串类型;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Classname 字符串中的第一个唯一字符387
 * @Description TODO
 * @Date 2021/7/3 21:26
 * @Created by xjl
 */
public class 字符串中的第一个唯一字符387 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int firstUniqChar2(String s) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            int flag = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                continue;
            } else {
                index = i;
            }
        }
        return index;
    }

    @Test
    public void test() {
        int leetcode = firstUniqChar("loveleetcode");
        System.out.println(leetcode);
    }

}
