/**
 * Copyright (C), 2018-2020
 * FileName: divisorGame
 * Author:   xjl
 * Date:     2020/7/24 10:45
 * Description: 除数博弈
 */
package Math;

import org.junit.Test;

public class divisorGame {

    public boolean divisorGame(int N) {
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                N = N - i;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        boolean b = divisorGame(3);
        System.out.println(b);
    }

}
