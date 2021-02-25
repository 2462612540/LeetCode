/**
 * Copyright (C), 2018-2020
 * FileName: titleToNumber
 * Author:   xjl
 * Date:     2020/3/2 14:57
 * Description: 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
package leetcode练习题;

public class titleToNumber {
    public static int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArray.length; i++) {
            res = res * 26 + (charArray[i] - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        titleToNumber("AZ");
    }
}
