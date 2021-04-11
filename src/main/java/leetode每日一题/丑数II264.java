package leetode每日一题;

import org.junit.Test;
import 牛客网练习题.Solution;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Classname 丑数II
 * @Description TODO
 * @Date 2021/4/10 10:32
 * @Created by xjl
 */
public class 丑数II264 {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        //使用了的最小堆的方式保证每一次处理的最小的数
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        //加入元素
        heap.offer(1L);
        int ugly = 0;
        //找到第n个丑数
        for (int i = 0; i < n; i++) {
            //取出堆顶元素
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public int nthUglyNumber3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] a = new int[n];
        a[0] = 1;
        int index1 = 0;   //遍历丑数的*2的队列
        int index2 = 0;   //遍历*3的队列
        int index3 = 0;   //遍历*5的队列
        for (int i = 1; i < n; i++) {
            a[i] = Math.min(Math.min(a[index1] * 2, a[index2] * 3), a[index3] * 5);
            //更新遍历三个对队列的下标
            if (a[i] == a[index1] * 2) {
                index1++;
            }
            if (a[i] == a[index2] * 3) {
                index2++;
            }
            if (a[i] == a[index3] * 5) {
                index3++;
            }
        }
        return a[n - 1];
    }

    public int nthUglyNumber4(int n) {
        if (n == 0) return 0;
        int[] res = new int[n];
        res[0] = 1;

        int two = 0;
        int three = 0;
        int five = 0;

        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[two] * 2, Math.min(res[three] * 3, res[five] * 5));
            if (res[i] == res[two] * 2) {
                two++;
            }
            if (res[i] == res[three] * 3) {
                three++;
            }
            if (res[i] == res[five] * 5) {
                five++;
            }
        }
        return res[n - 1];
    }

    @Test
    public void test() {
        int i = nthUglyNumber(10);
        System.out.println(i);
    }
}
