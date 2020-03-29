/**
 * Copyright (C), 2018-2020
 * FileName: Random
 * Author:   xjl
 * Date:     2020/3/10 15:16
 * Description: 随机算法
 */
package Loadbalancingalgorithm.RadomAri;

import Loadbalancingalgorithm.ServiceIPs;

import java.util.ArrayList;
import java.util.List;

public class Random {
    /**
     * 随机回去ip的值
     *
     * @return
     */
    public static String getService() {
        java.util.Random ra = new java.util.Random();
        return ServiceIPs.list.get(ra.nextInt(ServiceIPs.list.size()));
    }

    /**
     * 权重的访问的算法
     *
     * @return
     */
    public static String getService2() {
        List ips = new ArrayList();
        for (String ip : ServiceIPs.map.keySet()) {
            Integer weight = ServiceIPs.map.get(ip);
            for (int i = 0; i < weight; i++) {
                ips.add(ip);
            }
        }
        java.util.Random ra = new java.util.Random();
        return (String) ips.get(ra.nextInt(ips.size()));
    }

    /**
     * 就是在[5,5,8,2]-[A,B,C,D]
     * 现在随机一个数字 救会出现的8
     * 0------5------10------18----20
     * int find=8  8>5  find=8-5=3
     * 3<10   这个返回B
     *
     * @param args
     */

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getService2());
        }
    }
}
