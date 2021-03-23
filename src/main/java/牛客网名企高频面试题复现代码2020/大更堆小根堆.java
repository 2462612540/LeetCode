package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname 大更堆小根堆
 * @Description TODO
 * @Date 2020/12/9 19:02
 * @Created by xjl
 */
public class 大更堆小根堆 {

    public void max_min(int[] nums) {
        PriorityQueue<Integer> maxqueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> minqueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //插入
            int number = nums[i];
            sum++;
            maxqueue.add(number);
            minqueue.add(maxqueue.poll());
            if (sum % 2 == 1) {
                maxqueue.add(minqueue.poll());
            }

        }

        System.out.println("-----------max-------------------");
        while (!maxqueue.isEmpty()) {
            System.out.println((maxqueue.peek() + minqueue.peek()) / 2);
            System.out.print(maxqueue.poll() + " ");
        }
        System.out.println();
        System.out.println("-----------min--------------------");
        while (!minqueue.isEmpty()) {
            System.out.print(minqueue.poll() + " ");
        }

    }

    @Test
    public void test() {
        max_min(new int[]{1, 5, 8, 9, 7, 6, 5});
    }
}
