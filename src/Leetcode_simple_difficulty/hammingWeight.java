/**
 * Copyright (C), 2018-2020
 * FileName: hammingWeight
 * Author:   xjl
 * Date:     2020/4/2 11:49
 * Description: 二进制中1的个数
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

public class hammingWeight {
    public int hammingWeight(int n) {

        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    @Test
    public void tes() {
        hammingWeight(00000000000000000000000000001011);
    }
}
