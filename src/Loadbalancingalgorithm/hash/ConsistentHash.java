/**
 * Copyright (C), 2018-2020
 * FileName: ConsistentHash
 * Author:   xjl
 * Date:     2020/3/10 16:19
 * Description: 一致性hash算法
 */
package Loadbalancingalgorithm.hash;

import Loadbalancingalgorithm.ServiceIPs;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash {
    private static TreeMap<Integer, String> virtualnodes = new TreeMap();
    private static final int node = 160;

    static {
        for (String ip : ServiceIPs.list) {
            for (int i = 0; i < node; i++) {
                int hash = getHash(ip + i);
                virtualnodes.put(hash, ip);
            }
        }
    }

    private static int getHash(String string) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < string.length(); i++) {
            hash = (hash ^ string.charAt(i)) * p;
        }
        hash ^= hash << 13;
        hash += hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        //如果是算出来的值为负数则取绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    private static String getService(String client) {
        int hash = getHash(client);

        //大于hash virtualnodes的子树的fristkey的值
        SortedMap<Integer, String> sortedMap = virtualnodes.tailMap(hash);

        Integer fristkey = null;

        if (sortedMap == null) {
            fristkey = virtualnodes.firstKey();
        } else {
            fristkey = sortedMap.firstKey();
        }
        return virtualnodes.get(fristkey);
    }

    public static void main(String[] args) {

    }
}
