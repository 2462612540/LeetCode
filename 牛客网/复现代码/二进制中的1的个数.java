package 复现代码;

/**
 * @Classname 二进制中的1的个数
 * @Description TODO
 * @Date 2020/12/11 19:58
 * @Created by xjl
 */
public class 二进制中的1的个数 {
    public int test(int n) {
        int val = n;
        int ans = 0;
        while (val != 0) {
            ++ans;
            val = val & (val - 1);
        }
        return ans;
    }
}
