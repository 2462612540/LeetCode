/**
 * Copyright (C), 2018-2020
 * FileName: 加一66
 * Author:   xjl
 * Date:     2020/11/2 16:35
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class 加一66 {
    /**
     * 需要思考的是的最后一位加1的时候 是否大于10 考虑的是否需要进位  第一种采用的是的系统的库函数的爱解决来实现
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        String number = "";
        for (int i : digits) {
            number += String.valueOf(i);
        }
        String array = new BigDecimal(number).add(new BigDecimal(1)).toString();
        int[] result = new int[array.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.valueOf(array.charAt(i) - '0');
        }
        return result;
    }

    /**
     * 只要考虑的是最后的一位是否大于10 如果小于 那么就需要的是返回的是  如果是的大于则需要比较下一位
     *
     * @param digits
     * @return
     */
    public int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 就是的判断的进位是否大于 所以采用的是的假设能欧进位到最大  最后去判断数组开始的第一位是否大于0如果是大的话表示的进位了 否则就是没有
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        //最大的表示的数据
        int[] result = new int[digits.length + 1];
        //表示进位
        int con = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + con;
            if (i == digits.length - 1) {
                result[i + 1] = (sum + 1) % 10;
                con = (sum + 1) / 10;
            } else {
                result[i + 1] = (sum) % 10;
                con = (sum) / 10;
            }
        }
        //判断result的第一位置是否为0
        if (con != 0) {
            result[0] = con;
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, result.length);
        }
    }

    @Test
    public void test() {
        int[] ints = plusOne3(new int[]{9, 7, 9});
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
