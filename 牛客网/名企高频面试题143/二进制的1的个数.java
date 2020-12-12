package 名企高频面试题143;

/**
 * @Classname 二进制的1的个数
 * @Description TODO
 * @Date 2020/12/11 19:55
 * @Created by xjl
 */
public class 二进制的1的个数 {

    public int NumberOf1(int n) {
        int val = n;
        int ans = 0;
        while (val != 0) {
            ++ans;
            val = val & (val - 1);
        }
        return ans;
    }
}
