/**
 * Copyright (C), 2018-2020
 * FileName: reverseWords2
 * Author:   xjl
 * Date:     2020/4/2 14:10
 * Description: 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode;

import org.junit.Test;

public class reverseWords2 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String SS="";
        for (int i = strings.length-1; i >=0; i--) {
            if (!strings[i].equals("")){
                SS+=strings[i]+" ";
            }
        }
        return SS.trim();
    }

    @Test
    public void test() {
        String s="a good   example";
        reverseWords(s);
    }

}
