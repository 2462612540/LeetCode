package leetode每日一题;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname 反转字符串
 * @Description TODO
 * @Date 2021/4/8 13:38
 * @Created by xjl
 */
public class 反转字符串344 {
    /**
     * @description TODO 使用的是双指针的方法来实现 使用的空间复杂度最低 o(N/2)
     * @param: s
     * @date: 2021/4/8 13:56
     * @return: void
     * @author: xjl
    */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        for (char a : s) {
            System.out.print(a+" ");
        }
    }


    @Test
    public void test(){
        reverseString(new char[]{'h','e','l','l','o'});
    }
}
