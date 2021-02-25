/**
 * Copyright (C), 2018-2020
 * FileName: change
 * Author:   xjl
 * Date:     2020/7/5 22:01
 * Description: 在这个特殊的假期里，由于牛牛在家特别无聊，于是他发明了一个小游戏，游戏规则为：将字符串数字中为偶数位的数字进行翻转，将翻转后的结果进行输出。
 */
package leetcode练习题;

import org.junit.Test;

/**
 * 将字符串数字中为偶数位的数字进行翻转
 */
public class change {
    public String change1(String number) {

        String[] array = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = String.valueOf(number.charAt(i));
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            if (Integer.valueOf(array[start]) % 2 == 0 && Integer.valueOf(array[end]) % 2 == 0) {
                String temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
            if (Integer.valueOf(array[start]) % 2 != 0) {
                start++;
            }
            if (Integer.valueOf(array[end]) % 2 != 0) {
                end--;
            }
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    public String change2(String number) {
        if(number == null || number.length() == 0 || number.length() > Math.pow(10,7)){
            return number;
        }
        char[] temp = number.toCharArray();
        int left = 0;
        int right = temp.length - 1;

        while(left < right){
            if(temp[left]%2!=0){
                left++;
                continue;
            }
            if(temp[right]%2!=0){
                right--;
                continue;
            }

            char tempNum = temp[left];
            temp[left] = temp[right];
            temp[right] = tempNum;
            left++;
            right--;
        }
        return String.valueOf(temp);
    }

    @Test
    public void test() {
        String change = change2("12346");
        System.out.println(change);
    }

}
