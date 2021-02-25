/**
 * Copyright (C), 2018-2020
 * FileName: LeftRotateString
 * Author:   xjl
 * Date:     2020/5/9 14:09
 * Description: ，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.Arrays;

public class LeftRotateString {

    public String LeftRotateString(String str, int n) {
        if (n > str.length()) {
            return "";
        }
        return str.substring(n, str.length()) + str.substring(0, n);
    }

    public String ReverseSentence(String str) {
        String[] array = str.split(" ");
        String res = "";
        for (int i = array.length - 1; i >= 0; i--) {
            if (i - 1 < 0) {
                res += array[i];
            } else {
                res += array[i] + " ";
            }
        }
        return res;
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers.length==0){

        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0]=numbers[i];
            }
        }
        if (duplication[0]!=0){
            return true;
        }
        return false;
    }

    @Test
    public void test3() {

    }

    @Test
    public void test2() {
        System.out.println(ReverseSentence("I am a student.").toString());
    }

    @Test
    public void test() {
        System.out.println(LeftRotateString(",6", 2));
    }
}

