package leetode每日一题;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 根据字符出现频率排序451
 * @Description TODO
 * @Date 2021/7/3 16:47
 * @Created by xjl
 */
public class 根据字符出现频率排序451 {

    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());//这里是将所有的放在这里实现
        //这里采用的按照map中的遍历来实现的
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * @description TODO 采用的是的优先队列的方式的来实现 这里有一个重要的实现的就是：Map.Entry<Character, Integer> entry : map.entrySet()
     * @param: s
     * @date: 2021/7/3 19:56
     * @return: java.lang.String
     * @author: xjl
     */
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        String ans = "";
        while (!queue.isEmpty()) {
            int number = queue.peek().getValue();
            char ch = queue.peek().getKey();
            while (number > 0) {
                ans += ch;
                number--;
            }
            queue.poll();
        }
        return ans;
    }



    @Test
    public void test() {
        String tree = frequencySort("Aabb");
        System.out.println(tree);
    }
}
