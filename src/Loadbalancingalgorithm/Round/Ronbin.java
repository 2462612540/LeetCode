/**
 * Copyright (C), 2018-2020
 * FileName: Ronbin
 * Author:   xjl
 * Date:     2020/3/10 15:41
 * Description: 轮训的代码
 */
package Loadbalancingalgorithm.Round;

import Loadbalancingalgorithm.ServiceIPs;

public class Ronbin {
    private static Integer pos = 0;

    public static String getServce() {
        //大于总的数后面就从第0个开始访问
        if (pos >= ServiceIPs.list.size()) {
            pos = 0;
        }
        String ip = ServiceIPs.list.get(pos);
        pos++;
        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServce());
        }
    }
}
