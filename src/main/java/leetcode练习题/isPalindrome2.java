/**
 * Copyright (C), 2018-2020
 * FileName: isPalindrome2
 * Author:   xjl
 * Date:     2020/3/1 15:34
 * Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.List;

/**
 * 将字符转为小写且只有字母和数字可以放入
 * 利用双指针来遍历前后，
 * 如果全部遍历介绍的话那就是回文
 * 如果不是遍历完成的话那就回不是回文
 *
 * 这里学习到的是list的遍历和Array的排序方法。
 */
public class isPalindrome2 {
    public static boolean isPalindrome(String s) {
        char[] char1 = s.toLowerCase().toCharArray();
        List<Character> list=new ArrayList<>();
        for(int i=0;i<char1.length;i++){
            if(char1[i]>='a'&&char1[i]<='z'||char1[i]>='0'&&char1[i]<='9'){
                list.add(char1[i]);
            }
        }
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)!=list.get(list.size()-1-i)){
                  return false;
            }
        }
        return  true;
}

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
