/**
 * Copyright (C), 2018-2020
 * FileName: lastRemaining
 * Author:   xjl
 * Date:     2020/3/5 17:30
 * Description: 约瑟夫环的问题
 */
package 牛客网练习题;

public class lastRemaining {
    /**
     * s这是约瑟夫环的问题
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p;
    }
}
