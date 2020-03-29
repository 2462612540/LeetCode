/**
 * Copyright (C), 2018-2020
 * FileName: TreeMaptTest
 * Author:   xjl
 * Date:     2020/3/10 16:09
 * Description: 哈希算法
 */
package Loadbalancingalgorithm.hash;

import java.util.SortedMap;

public class TreeMaptTest {
    public static void main(String[] args) {
        java.util.TreeMap treeMap = new java.util.TreeMap();
        treeMap.put("1", "1");
        treeMap.put("2", "2");
        treeMap.put("3", "3");
        treeMap.put("4", "4");
        treeMap.put("5", "5");
        treeMap.put("6", "6");
        treeMap.put("7", "7");

        SortedMap sortedMap=treeMap.tailMap("4");
        System.out.println(sortedMap.firstKey());
        System.out.println(treeMap.firstKey());
    }

}
