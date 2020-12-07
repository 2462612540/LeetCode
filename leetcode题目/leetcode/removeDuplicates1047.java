/**
 * Copyright (C), 2018-2020
 * FileName: removeDuplicates1047
 * Author:   xjl
 * Date:     2020/6/29 10:46
 * Description: 1047. 删除字符串中的所有相邻重复项
 */
package leetcode;

import org.junit.Test;

public class removeDuplicates1047 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String res = removeDuplicates("abbaca");
        System.out.println(res);

    }
}
