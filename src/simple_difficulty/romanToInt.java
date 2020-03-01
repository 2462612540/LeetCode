/**
 * Copyright (C), 2018-2020
 * FileName: romanToInt
 * Author:   xjl
 * Date:     2020/2/29 11:06
 * Description: 罗马数字转整数
 */
package simple_difficulty;

import java.util.*;

/**
 * 1将这个罗马的数据存在map中 并将string转化
 * 2 遍历String 中的一个字符
 * 存在以下的三种的情况的话那么久要用简单
 * 如果不是的有那么就用加法
 */
public class romanToInt {

    public static int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] array = s.toCharArray();
        for(int i=0;i<array.length;i++){
            if((i+1)==array.length){
                //还剩最后一个了
                result+=map.get(array[i]);
            }else {
                if(array[i]=='I'){
                    //检查右边时候为这个
                    if(array[i+1]=='V'||array[i+1]=='X'){
                        result+=map.get(array[i+1])-map.get(array[i]);
                        i=i+1;
                    }else {
                        result+=map.get(array[i]);
                    }
                }else if(array[i]=='X'){
                    //检查右边时候为这个
                    if(array[i+1]=='L'||array[i+1]=='C'){
                        result+=map.get(array[i+1])-map.get(array[i]);
                        i=i+1;
                    }else {
                        result+=map.get(array[i]);
                    }
                }else if(array[i]=='C'){
                    //检查右边时候为这个
                    if(array[i+1]=='D'||array[i+1]=='M'){
                        result+=map.get(array[i+1])-map.get(array[i]);
                        i=i+1;
                    }else {
                        result+=map.get(array[i]);
                    }
                }else {
                    result+=map.get(array[i]);
                }
            }
        }
        //输入确保在 1 到 3999 的范围内。
        if(result>=1&&result<=3999){
            return result;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "I";
        System.out.println(romanToInt(s));

    }
}
