package leetode每日一题;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname test2
 * @Description TODO
 * @Date 2021/3/24 20:57
 * @Created by xjl
 */
public class test2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);//从小到大顺序
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);//从大到小的顺序
        pq.add(4);
        pq.add(2);
        pq.add(8);
        pq.add(9);
        pq.add(10);
        pq.add(0);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}
