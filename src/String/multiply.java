/**
 * Copyright (C), 2018-2020
 * FileName: multiply
 * Author:   xjl
 * Date:     2020/8/13 16:07
 * Description:
 */
package String;

import java.math.BigInteger;

public class multiply {

    public String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

    /**
     * 采用的是一个多个数的加起来
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        //num[i]* num2[j]:  res[i+j+1]      res[i+j]
        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                res[i + j + 1] += a * b;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] %= 10;
            }
        }
        StringBuilder result=new StringBuilder();
        int i=0;
        while (res[i]==0){
            i++;
        }
       for (;i<res.length;i++){
           result.append(res[i]);
       }
        return result.toString();
    }
}
