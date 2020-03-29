/**
 * Copyright (C), 2018-2020
 * FileName: myAtoi
 * Author:   xjl
 * Date:     2020/3/15 15:07
 * Description: 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class myAtoi {
    public int myAtoi(String str) {
        if(str.charAt(0)!=' '&&str.charAt(0)>'9'&&str.charAt(0)<'0'){return 0;}
        int count=0,sum=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                continue;
            }

        }
        return 0;
    }
    @Test
    public void  test(){
        myAtoi("     ---42");
    }
}
