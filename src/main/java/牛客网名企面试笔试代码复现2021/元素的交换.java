package 牛客网名企面试笔试代码复现2021;

import org.junit.Test;

/**
 * @Classname 元素的交换
 * @Description TODO
 * @Date 2021/2/27 10:04
 * @Created by xjl
 */
public class 元素的交换 {
    @Test
    public void test() {
        int[] res = change(3, 2);
        System.out.println(res[0]+"==="+res[1]);
    }
    /**
     * @description TODO 元素的交换的代码
     * @param: a
     * @param: b
     * @date: 2021/2/27 10:08
     * @return: int[]
     * @author: xjl
    */
    public int[] change(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }
}
