/**
 * Copyright (C), 2018-2020
 * FileName: findNthDigit44
 * Author:   xjl
 * Date:     2020/6/3 14:23
 * Description: 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 */
package NewLeetcode;

import org.junit.Test;

public class findNthDigit44 {
    public int findNthDigit(int n) {
        if (n < 0 || n >= Math.pow(2, 31)) {
            return 0;
        }
        return 0;
    }

    @Test
    public void test() {
        int nthDigit = findNthDigit(3);
        System.out.println();
    }
}
