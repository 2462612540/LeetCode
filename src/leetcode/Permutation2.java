/**
 * Copyright (C), 2018-2020
 * FileName: Permutation2
 * Author:   xjl
 * Date:     2020/7/15 16:21
 * Description: quanpailie
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;

public class Permutation2 {

    public ArrayList<String> Permutation(String str) {
        char[] array = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        slove(array, result, 0, str.length());
        return result;
    }

    private void slove(char[] array, ArrayList<String> result, int index, int length) {
        if (index == length - 1) {
            String res = chage(array);
            result.add(res);
        } else {
            //说明要去确定indxd的位置
            for (int i = index; i < length; i++) {
                char temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                //那么就是递归的调用到洗衣歌位置的字符
                slove(array, result, index + 1, length);
                //为了消除递归的时候的进行的交换的字符的影响
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }

    private String chage(char[] array) {
        StringBuilder res = new StringBuilder();
        for (char value : array) {
            res.append(value);
        }
        return res.toString();
    }

    public int reletive_7 (int[] digit) {
       String Str="";
       for (int i=0;i<digit.length;i++){
           Str+=String.valueOf(digit[i]);
       }
        ArrayList<String> list = Permutation(Str);
        int[] result=new int[list.size()];
        for (int i=0;i<result.length;i++){
            result[i]=Integer.valueOf(list.get(i));
        }
        int count=0;
        for (int i=0;i<result.length;i++){
            if (result[i]%7==0){
                count++;
            }
        }
        return count;
    }
    @Test
    public void test(){
        int[] arr={1,1,2};
        int result = reletive_7(arr);
        System.out.println(result);
    }
}
