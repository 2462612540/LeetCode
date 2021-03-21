package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

/**
 * @Classname 字符串翻译
 * @Description TODO   没有0对应的时候 a-1  b-1  z-25
 * @Date 2020/12/8 10:41
 * @Created by xjl
 */
public class 数字翻译字符串 {
    @Test
    public void test() {
        int print = print("12258");
        System.out.println(print);
    }

    public int print(String nums) {
        return slove(nums.toCharArray(), 0);
    }

    private int slove(char[] CharArray, int start) {
        //终端条件
        if (start >= CharArray.length) {
            return 1;
        }
        //考虑一个数字翻译为一种的是时候
        int res1 = slove(CharArray, start + 1);
        //两个翻译到一起的时候
        int res2 = 0;
        if ((start < CharArray.length - 1) && ((CharArray[start] - '0') * 10 + (CharArray[start + 1] - '0') > 9 && (CharArray[start] - '0') * 10 + (CharArray[start + 1] - '0') <= 25)) {
            res2 = slove(CharArray, start + 2);
        }
        return res1 + res2;
    }
}
