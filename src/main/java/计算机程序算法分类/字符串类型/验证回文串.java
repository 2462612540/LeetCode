package 计算机程序算法分类.字符串类型;

import org.junit.Test;

/**
 * @Classname 最长字符串
 * @Description TODO
 * @Date 2021/4/13 14:22
 * @Created by xjl
 */
public class 验证回文串 {
    /**
     * @description TODO  只考虑字母和数字字符 遍历的所有的字符串
     * @param: s
     * @date: 2021/4/13 16:24
     * @return: boolean
     * @author: xjl
     */
    public boolean isPalindrome(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                str += s.charAt(i);
            }
        }
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return new StringBuilder(str.toLowerCase()).reverse().toString().equals(str.toLowerCase());
    }

    public boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            //确定指定字符是字母还是数字
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    @Test
    public void test() {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }
}
