package 名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 名企高频面试题143.旋转字符串
 * @Description TODO  字符串旋转:
 * 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 * 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。
 * @Date 2020/12/7 10:11
 * @Created by xjl
 */
public class 旋转字符串 {
    /**
     * @description TODO 利用的subString的函数来实现
     * @param: A
     * @param: B
     * @date: 2020/12/7 10:13
     * @return: boolean
     * @author: xjl
     */
    public boolean solve(String A, String B) {
        return B.equals(A.substring((A.length()) / 2) + A.substring(0, A.length() / 2));
    }

    @Test
    public void test() {
        boolean solve = solve("youzan", "zanyou");
        System.out.println(solve);
    }
}
