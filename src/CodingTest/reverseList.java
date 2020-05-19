/**
 * Copyright (C), 2018-2020
 * FileName: reverseList
 * Author:   xjl
 * Date:     2020/5/19 20:01
 * Description: 链表的翻转
 */
package CodingTest;

import org.junit.Test;

public class reverseList {

    public String filterContent(String content) {
        String result = "";
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) >= '0' && content.charAt(i) <= '9') {
                continue;
            } else {
                result += content.charAt(i);
            }
        }
        System.out.println(result);
        return result;
    }

    @Test
    public void test() {
        filterContent("作者大大0，为你点赞");
    }



}
