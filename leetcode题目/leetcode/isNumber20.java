/**
 * Copyright (C), 2018-2020
 * FileName: isNumber20
 * Author:   xjl
 * Date:     2020/6/2 10:37
 * Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode;

public class isNumber20 {
    public boolean isNumber(String s) {
        if (s.startsWith("f") || s.endsWith("d") || s.startsWith("F") || s.startsWith("D")) {
            return false;
        }
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isNumber1(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        s = s.replace('E', 'e');
        if (s.indexOf('e') >= 0) {
            int indxE = s.indexOf('e');
            String frsit = s.substring(0, indxE);
            String second = s.substring(indxE+1);
            if (second.length() > 0) {
                if (second.charAt(0) == '+' || second.charAt(0) == '-') {
                    second = second.substring(1);
                }
            }
            return validNumber(frsit) && validPurNumber(second);
        }
        return validNumber(s);
    }

    private boolean validNumber(String s) {
        if (s.indexOf('.') >= 0) {
            int indxp = s.indexOf('.');
            String frist = s.substring(0, indxp);
            String second = s.substring(indxp + 1);
            if (frist.length() > 0 && second.length() > 0) {
                return validPurNumber(frist) && validPurNumber(second);
            } else if (second.length() > 0) {
                return validPurNumber(second);
            } else {
                return validPurNumber(frist);
            }
        }
        return validPurNumber(s);
    }

    private boolean validPurNumber(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }

}
