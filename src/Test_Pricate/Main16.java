/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package Test_Pricate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int count = 0;
        //循环判断[L, R]区间内的每一个数字是否为即为回文又为素数
        for (int i = l; i <= r; i++) {
            //怎么样除去点一个数字
            String s1 = String.valueOf(i);
            for (int j = 0; j < s1.length(); j++) {
                String str = "";
                for (int k = 0; k < s1.length(); k++) {
                    if (k == j) {
                        continue;
                    } else {
                        str += s1.charAt(k);
                    }
                }
                if (str == "") {
                    break;
                }
                if (str.length() == 1) {
                    count++;
                    break;
                }
                if (Integer.valueOf(str) < 1) {
                    break;
                }
                if (isPalindrome(Integer.valueOf(str)) && isprime(Integer.valueOf(str))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    //判断一个数是否为素数
    public static boolean isprime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //判断一个数是否为回文
    public static boolean isPalindrome(int n) {
        int k = n;
        int num = 0;
        while (k != 0) {
            num = num * 10 + k % 10;
            k = k / 10;
        }
        return num == n;
    }
}

