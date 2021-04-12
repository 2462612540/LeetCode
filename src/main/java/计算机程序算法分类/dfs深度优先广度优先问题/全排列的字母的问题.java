package 计算机程序算法分类.dfs深度优先广度优先问题;

import leetcode练习题.permute;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname 全排列的字母的问题
 * @Description TODO
 * @Date 2021/4/11 15:28
 * @Created by xjl
 */
public class 全排列的字母的问题 {
    //要求有顺序的输出
    public List<String> permute(String strings) {
        List<String> result = new ArrayList<>();
        if (strings.length() == 0) return result;
        int index = 0;
        String str = "";
        boolean[] vis = new boolean[strings.length()];
        //利用的最小的堆来保证的顺序的
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        dfs(pq, index, str, vis, strings);
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }

    private void dfs(PriorityQueue<String> pq, int index, String str, boolean[] vis, String arr) {
        if (index == arr.length()) {
            pq.add(str);
            return;
        } else {
            for (int i = 0; i < arr.length(); i++) {
                if (vis[i] == false) {
                    str += arr.charAt(i);
                    //表示已经访问过了
                    vis[i] = true;
                    dfs(pq, index + 1, str, vis, arr);
                    //删除的最后一个
                    str = str.substring(0, str.length() - 1);
                    vis[i] = false;
                }
            }
        }
    }

    @Test
    public void test() {
        List<String> permute = permute("bac");
        for (String s : permute) {
            System.out.println(s);
        }

//        String str = "123456";
//        System.out.println(str.substring(0, str.length() - 1));
    }
}
