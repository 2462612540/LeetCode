package 计算机程序算法分类.队列问题;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname 前K个高频单词692
 * @Description TODO
 * @Date 2021/5/20 10:23
 * @Created by xjl
 */
public class 前K个高频单词692 {

    public List<String> topKFrequent3(String[] words, int k) {
        List<String> ans = Arrays.stream(words)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().equals(o1.getValue()) ? o1.getKey().compareTo(o2.getKey()) : Long.compare(o2.getValue(), o1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());;
        return ans;
    }

    /**
     * @description TODO  返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 可以采用的是hashmap  可以采用的优先队列来实现
     * @param: words 意思就是当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
     * @param: k
     * @date: 2021/5/20 10:27
     * @return: java.util.List<java.lang.String>
     * @author: xjl
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        List<String> rec = new ArrayList<String>();

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }

        Collections.sort(rec, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return cnt.get(word1).equals(cnt.get(word2)) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
        return rec.subList(0, k);
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        //定义好优先队列
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().equals(entry2.getValue()) ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        //
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            //如果是对于的k的个数的时候那就的删除的前面的
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}
