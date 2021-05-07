package 计算机程序算法分类.数组问题;

import org.junit.Test;

/**
 * @Classname 数组的异或操作1486
 * @Description TODO
 * @Date 2021/5/7 9:13
 * @Created by xjl
 */
public class 数组的异或操作1486 {

    int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }
        int sum = start;
        for (int i = 1; i < n; i++) {
            sum = sum ^ (start + 2 * i);
        }
        return sum;
    }

    @Test
    public void test() {
        int i = xorOperation(5, 0);
        System.out.println(i);
    }
}
