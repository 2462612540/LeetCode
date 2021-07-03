package 计算机程序算法分类.字符串类型;

import org.junit.Test;

/**
 * @Classname 最后一个单词的长度58
 * @Description TODO
 * @Date 2021/6/28 19:21
 * @Created by xjl
 */
public class 最后一个单词的长度58 {
    /**
     * @description TODO 采用了系统函数的实现功能
     * @param: s
     * @date: 2021/6/29 11:36
     * @return: int
     * @author: xjl
     */
    public int lengthOfLastWord(String s) {
        if (s.split(" ").length == 0) {
            return 0;
        }
        return s.split(" ")[s.split(" ").length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                //为了保证的后面的都是的空格的话那就还是要继续的
                if (count > 0) {
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLastWord(" "));
    }
}
