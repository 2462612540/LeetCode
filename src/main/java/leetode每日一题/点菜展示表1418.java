package leetode每日一题;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname 点菜展示表1418
 * @Description TODO
 * @Date 2021/7/6 9:43
 * @Created by xjl
 */
public class 点菜展示表1418 {
    public static void main(String[] args) {

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<String, Map<String, Integer>> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1) - Integer.valueOf(o2);
            }
        });
        //记录好最长的食物的菜单 这里已经排序好了
        TreeSet<String> food = new TreeSet<>();
        //记录好最长的菜单
        for (List<String> list : orders) {
            food.add(list.get(2));
        }
        //开始遍历
        for (List<String> list : orders) {
            String tableNumber = list.get(1);
            String foodItem = list.get(2);
            //不包含的
            if (!treeMap.containsKey(tableNumber)) {
                TreeMap<String, Integer> map = new TreeMap<>();
                //将新全部赋值
                for (String str : food) {
                    if (foodItem == str) {
                        map.put(str, 1);
                    } else {
                        map.put(str, 0);
                    }
                    treeMap.put(tableNumber, map);
                }
                //已经存在的
            } else {
                //如果有的话 查看将相关的值加1
                Map<String, Integer> stringIntegerMap = treeMap.get(tableNumber);
                stringIntegerMap.put(foodItem, stringIntegerMap.get(foodItem) + 1);
            }
        }
        //保存输出结果
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> tabale = new ArrayList<>();
        tabale.add("Table");
        for (String str : food) {
            tabale.add(str);
        }
        res.add(tabale);
        for (String string : treeMap.keySet()) {
            ArrayList<String> list1 = new ArrayList<>();
            list1.add(string);
            Map<String, Integer> stringMap = treeMap.get(string);
            for (String ss : stringMap.keySet()) {
                list1.add(stringMap.get(ss).toString());
            }
            res.add(list1);
        }
        return res;
    }


    @Test
    public void test() {
        List<List<String>> res = new ArrayList<>();
        String[] arry1 = {"wdS", "1", "jOWOr"};
        String[] arry2 = {"Lo", "2", "jOWOr"};
        String[] arry3 = {"utgb", "1", "jOWOr"};
        String[] arry4 = {"lfgZ", "1", "jOWOr"};
        String[] arry5 = {"vzZ", "2", "jOWOr"};
//      String[] arry6 = {"Rous", "3", "Ceviche"};

        ArrayList<String> arrayList1 = (ArrayList<String>) Stream.of(arry1).collect(Collectors.toList());
        ArrayList<String> arrayList2 = (ArrayList<String>) Stream.of(arry2).collect(Collectors.toList());
        ArrayList<String> arrayList3 = (ArrayList<String>) Stream.of(arry3).collect(Collectors.toList());
        ArrayList<String> arrayList4 = (ArrayList<String>) Stream.of(arry4).collect(Collectors.toList());
        ArrayList<String> arrayList5 = (ArrayList<String>) Stream.of(arry5).collect(Collectors.toList());
//        ArrayList<String> arrayList6 = (ArrayList<String>) Stream.of(arry6).collect(Collectors.toList());

        res.add(arrayList1);
        res.add(arrayList2);
        res.add(arrayList3);
        res.add(arrayList4);
        res.add(arrayList5);
//        res.add(arrayList6);

        List<List<String>> lists = displayTable(res);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}
