/**
 * Copyright (C), 2018-2020
 * FileName: HashMapSort
 * Author:   xjl
 * Date:     2020/8/28 10:45
 * Description:
 */
package Hash_Map;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class HashMapSort {

    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() {
        Map<String, Integer> map = new HashMap();
        map.put("Apple", 7299);
        map.put("SAMSUNG", 6000);
        map.put("Meizu", 2698);
        map.put("Xiaomi", 2400);
        System.out.println("______________________//按照原始顺序排列__________________________________");
        //key-sort
        for (String s : map.keySet()) {
            System.out.println(s + "--" + map.get(s));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        System.out.println("________________________//按照的key的顺序排列_____________________________");
        //value-sort
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }
        System.out.println("________________________//按照的key的倒序排列_______________________________");
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }

        System.out.println("________________________//按照的value的顺序排列_____________________________");
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }

        System.out.println("________________________//按照的value的倒序排列__________________________");
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }
    }

    public static void test1() throws Exception {

        // 创建一个字符串为Key，数字为值的map
        Map<String, Integer> map = new HashMap<>();
        map.put("clothes", 120);
        map.put("grocery", 150);
        map.put("transportation", 100);
        map.put("utility", 130);
        map.put("rent", 1150);
        map.put("miscellneous", 90);

        System.out.println("______________________排序前___________________________ ");
        for (String key : map.keySet()) {
            System.out.println(key + "--" + map.get(key));
        }

        System.out.println("______________________//按值升序排序后___________________________ ");

        Map<String, Integer> sorted = map
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (String key : sorted.keySet()) {
            System.out.println(key + "--" + sorted.get(key));
        }
        System.out.println("______________________按值排序降序排序后___________________________ ");
        sorted = map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (String key : sorted.keySet()) {
            System.out.println(key + "--" + sorted.get(key));
        }
    }

    public static void test2() {
        Map<String, String> map = new HashMap<>();
        map.put("apple", "55");
        map.put("boy", "32");
        map.put("cat", "22");
        map.put("dog", "12");
        map.put("egg", "11");
        Object[] arr = map.keySet().toArray();
        Arrays.sort(arr);
        for (Object key : arr) {
            System.out.println(key + "--" + map.get(key));
        }
    }
}



