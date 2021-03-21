package 牛客网名企高频面试题2020;

import org.junit.Test;

/**
 * @Classname 名企高频面试题143.判断字符串是否为回文
 * @Description TODO
 * @Date 2020/12/7 15:35
 * @Created by xjl
 */
public class 判断字符串是否为回文 {
    /**
     * @description TODO 时间的复杂度是的n/2
     * @param: str
     * @date: 2020/12/7 15:44
     * @return: boolean
     * @author: xjl
     */
    public boolean judge(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        boolean res = judge("ranko");
        System.out.println(res);
    }
}
