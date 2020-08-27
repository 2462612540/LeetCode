/**
 * Copyright (C), 2018-2020
 * FileName: theEndOfN
 * Author:   xjl
 * Date:     2020/8/25 16:41
 * Description: n的阶乘的末尾为0
 */
package Math;

public class theEndOfN {

    public static int solve(int N) {
        int count =  0;
        for(int i = 1 ; i <= N ;i++){
            int j = i ;
            while (j %5 == 0) {
                count++;
                j = j/5;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(solve(N));
    }
}
