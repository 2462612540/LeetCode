/**
 * Copyright (C), 2018-2020
 * FileName: 大数字相加
 * Author:   xjl
 * Date:     2020/9/30 22:32
 * Description:
 */
package 牛客面试必会100题;

import java.math.BigDecimal;

public class 大数字相加 {
    /**
     * 使用的是的一一个系统的函数
     *
     * @param s
     * @param t
     * @return
     */
    public String solve(String s, String t) {
        BigDecimal a = new BigDecimal(s);
        BigDecimal b = new BigDecimal(t);
        return a.add(b).toString();
    }

    /**
     * 利用的字串串的相加
     */

    public String solve1(String s, String t) {
        String ns1 = new StringBuilder(s).reverse().toString();
        String sn2 = new StringBuilder(t).reverse().toString();

        return null;
    }

}
