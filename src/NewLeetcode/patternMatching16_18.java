/**
 * Copyright (C), 2018-2020
 * FileName: patternMatching16_18
 * Author:   xjl
 * Date:     2020/6/22 16:44
 * Description: 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pattern-matching-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package NewLeetcode;

public class patternMatching16_18 {
    public boolean patternMatching(String pattern, String value) {
        // alen =0,vlen/a ofmount
        // blen= vlen-alen of a/b of mount
        if (pattern.length() == 0) {
            return false;
        }
        int vlen = value.length();
        int plen = pattern.length();
        int[] freq = new int[2];
        for (int i = 0; ; )

            return true;
    }

}
