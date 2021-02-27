package 牛客网名企面试笔试代码复现2021;

import org.junit.Test;

/**
 * @Classname 出现1的个数
 * @Description TODO
 * @Date 2021/2/27 10:10
 * @Created by xjl
 */
public class 出现1的个数 {
    @Test
    public void test() {
        int res = one(10);
        System.out.println(res);

        int i = hammingWeight(10);
        System.out.println("i="+i);
    }

    public int one(int n) {
        int count = 0;
        while (n != 0) {
            count+=n & 1;
            n >>>= 1;
        }
        return count;
    }


    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

}
