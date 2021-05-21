package 计算机程序算法分类.队列问题;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname 最近的请求次数933
 * @Description TODO
 * @Date 2021/5/20 20:11
 * @Created by xjl
 */
public class 最近的请求次数933 {
    Queue<Integer> q;

    /**
     * @description TODO 构造函数
     * @param:
     * @date: 2021/5/20 20:11
     * @return:
     * @author: xjl
     */
    public 最近的请求次数933() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
