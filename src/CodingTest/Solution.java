/**
 * Copyright (C), 2018-2020
 * FileName: Solution
 * Author:   xjl
 * Date:     2020/5/19 20:18
 * Description: ce
 */
package CodingTest;

public class Solution {

    public String filterContent (String content) {
        String result = "";
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) > '0' && content.charAt(i) <= '9') {
                continue;
            } else {
                result += content.charAt(i);
            }
        }
        System.out.println(result);
        return result;
    }


}
