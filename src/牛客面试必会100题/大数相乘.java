/**
 * Copyright (C), 2018-2020
 * FileName: 大数相乘
 * Author:   xjl
 * Date:     2020/10/1 8:50
 * Description:
 */
package 牛客面试必会100题;

import java.math.BigDecimal;

public class 大数相乘 {

    public String solve1(String s, String t) {

        return null;
    }

    /**
     * 利用的系统的函数
     *
     * @param s
     * @param t
     * @return
     */
    public String solve(String s, String t) {
        return new BigDecimal(s).multiply(new BigDecimal(t)).toString();
    }
}
