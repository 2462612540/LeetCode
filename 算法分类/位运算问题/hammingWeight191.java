/**
 * Copyright (C), 2018-2020
 * FileName: hammingWeight191
 * Author:   xjl
 * Date:     2020/11/7 12:04
 * Description:
 */
package 位运算问题;

public class hammingWeight191 {
    public static void main(String[] args) {

    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++; // 判断最低位是否是 1，是则计数器 +1
            n >>>= 1; // 舍弃最低位，继续判断下一位（会有负数情况，因此应该使用无符号右移）
        }
        return count;
    }
}


