package 名企高频面试题143;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Classname 出现topK的数字
 * @Description TODO
 * @Date 2020/12/17 16:10
 * @Created by xjl
 */
public class 出现topK的数字 {
    public String[][] topKstrings(String[] strings, int k) {

        PriorityQueue<MyNode> queue = new PriorityQueue<>(new MyComparator());

        HashMap<String, Integer> map = new HashMap<>(16);
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])) {
                map.put(strings[i], map.get(strings[i]) + 1);
            } else {
                map.put(strings[i], 1);
            }
        }
        //入堆
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(new MyNode(entry.getKey(), entry.getValue()));
        }
        String[][] result = new String[k][2];
        int j = 0;
        while (j < k && !queue.isEmpty()) {
            MyNode node = queue.poll();
            result[j][0] = node.val;
            result[j++][1] = String.valueOf(node.num);
        }
        return result;
    }

    class MyNode {
        String val;
        int num;

        MyNode(String val, int num) {
            this.num = num;
            this.val = val;
        }
    }

    class MyComparator implements Comparator<MyNode> {
        @Override
        public int compare(MyNode o1, MyNode o2) {
            if (o1.num == o2.num) {
                //字典序小的在前 所以 o1 比 o2
                return o1.val.compareTo(o2.val);
            } else {
                //数量大的在前所以 o2 - o1
                return o2.num - o1.num;
            }
        }
    }
}
