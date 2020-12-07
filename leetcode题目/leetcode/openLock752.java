/**
 * Copyright (C), 2018-2020
 * FileName: openLock752
 * Author:   xjl
 * Date:     2020/7/27 16:18
 * Description:
 */
package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class openLock752 {
    // 将 s[j] 向上拨动⼀次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    // 将 s[i] 向下拨动⼀次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    // BFS 框架， 打印出所有可能的密码
    void BFS(String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                /* 判断是否到达终点 */
                System.out.println(cur);
                /* 将⼀个节点的相邻节点加⼊队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    q.offer(up);
                    q.offer(down);
                }
            }
            /* 在这⾥增加步数 */
        }
        return;
    }

    @Test
    public void test() {
        String[] str = {"0201", "0101", "0102", "1212", "2002"};
        int i = openLock(str, "0202");
        System.out.println("result=" + i);
    }

    int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 记录已经穷举过的密码， 防⽌⾛回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动⼴度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                /* 判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;
                /* 将⼀个节点的未遍历相邻节点加⼊队列  这里是的4个数字*/
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            /* 在这⾥增加步数 */
            step++;
        }
        // 如果穷举完都没找到⽬标密码， 那就是找不到了
        return -1;
    }
}
