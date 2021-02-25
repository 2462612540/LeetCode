package 牛客网名企高频面试题;

import org.junit.Test;

/**
 * @Classname 最长公共前缀
 * @Description TODO
 * @Date 2020/12/8 13:17
 * @Created by xjl
 */
public class 最长公共前缀 {

    @Test
    public void test() {
        String s = longestCommonPrefix(new String[]{"abca", "abc", "abca", "abc", "abcc"});
        System.out.println(s);
    }

    /**
     * @description TODO 采用的是最长公共前缀的就是采用是遍历的方式来判断一次判断
     * @param: strs
     * @date: 2020/12/8 13:20
     * @return: java.lang.String
     * @author: xjl
     */
    public String longestCommonPrefix(String[] strs) {
        //判断数组安全
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = fit(res, strs[i]);
        }
        return res;
    }

    /**
     * @description TODO 表示的两个字符串的相同的部分前缀
     * @param: res
     * @param: str
     * @date: 2020/12/8 13:22
     * @return: java.lang.String
     * @author: xjl
     */
    private String fit(String res, String str) {
        //判断短的字符是哪一个 res 是短的 str是长的
        if (res.length() > str.length()) {
            String tmp = res;
            res = str;
            str = tmp;
        }
        for (int i = res.length() - 1; i >= 0; i--) {
            if (str.contains(res.substring(0, i + 1))) {
                return res.substring(0, i + 1);
            }
        }
        return "";
    }

    /**
     * @description TODO 表示的是是的纵向想扫描的结果
     * @param: strs
     * @date: 2020/12/8 13:53
     * @return: java.lang.String
     * @author: xjl
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            //第一列的元素判断时候后面的元素时候
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //表示的是第1个到最后的一个
                if (strs[j].length() <= i || ch != strs[j].charAt(i)) {
                    return sb.length() == 0 ? "" : sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
