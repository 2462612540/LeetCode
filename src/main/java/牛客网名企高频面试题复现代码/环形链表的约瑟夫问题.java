package 牛客网名企高频面试题复现代码;

import java.util.ArrayList;

/**
 * @Classname 环形链表的约瑟夫问题
 * @Description TODO
 * @Date 2020/12/22 18:40
 * @Created by xjl
 */
public class 环形链表的约瑟夫问题 {
    /**
     * @description TODO   约瑟夫问题
     * @param: n
     * @param: m
     * @date: 2020/12/22 18:50
     * @return: int
     * @author: xjl
     */
    public int ysf(int n, int m) {
        //1 通过的链表
        if (n == 0 || m == 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int removeIndex = 0;
        while (list.size() != 1) {
            removeIndex = (removeIndex + m - 1) % list.size();
            list.remove(removeIndex);
        }
        return list.get(0);

    }

    /**
     * @description TODO   f(n,m)=(f(n-1,m)+m)%n
     * @param: n
     * @param: m
     * @date: 2020/12/22 18:55
     * @return: int
     * @author: xjl
     */
    public int ysf1(int n, int m) {
        //通过的数学公式
        if (n == 0 || m == 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    public int ysf2(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = ysf2(n - 1, m);
        return (m + x) % n;
    }
}
