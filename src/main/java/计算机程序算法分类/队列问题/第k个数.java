package 计算机程序算法分类.队列问题;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Classname 第k个数
 * @Description TODO
 * @Date 2021/5/20 20:29
 * @Created by xjl
 */
public class 第k个数 {

    @Test
    public void test() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();//默认最小堆的实现
        queue.add(2);
        queue.add(4);
        queue.add(0);
        queue.add(-2);
        queue.add(8);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public int getKthMagicNumber2(int k) {
        // 最小堆处理写入数值  试了Integer不够
        PriorityQueue<Long> PriorityQueue = new PriorityQueue<>();
        // HashSet 保存k个位数值
        Set<Long> set = new HashSet<>();
        PriorityQueue.add(1L);
        while (true) {
            // 获取并删除队首元素
            Long val = PriorityQueue.poll();
            // 该元素是否已在HashSet中，在将不操作，否则插入
            if (!set.contains(val)) {
                set.add(val);
                PriorityQueue.add(val * 3);
                PriorityQueue.add(val * 5);
                PriorityQueue.add(val * 7);
            }
            // 返回第k个位数值
            if (set.size() == k) {
                return val.intValue();
            }
        }
    }

    public int getKthMagicNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] a = new int[n];
        a[0] = 1;
        int index1 = 0;   //遍历丑数的*3的队列
        int index2 = 0;   //遍历*5的队列
        int index3 = 0;   //遍历*7的队列

        for (int i = 1; i < n; i++) {
            a[i] = Math.min(Math.min(a[index1] * 3, a[index2] * 5), a[index3] * 7);
            //更新遍历三个对队列的下标
            if (a[i] == a[index1] * 3) {
                index1++;
            }
            if (a[i] == a[index2] * 5) {
                index2++;
            }
            if (a[i] == a[index3] * 7) {
                index3++;
            }
        }
        return a[n - 1];
    }
}
