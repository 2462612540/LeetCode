/**
 * Copyright (C), 2018-2020
 * FileName: ServiceIPs
 * Author:   xjl
 * Date:     2020/3/10 15:13
 * Description: 服务的Ip地址
 */
package Loadbalancingalgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceIPs {
    public static final List<String> list = Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8",
            "192.168.0.9",
            "192.168.0.10"
    );

    public static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("192.168.0.1", 2);
        map.put("192.168.0.2", 1);
        map.put("192.168.0.3", 6);
        map.put("192.168.0.4", 5);
        map.put("192.168.0.5", 8);
        map.put("192.168.0.6", 2);
        map.put("192.168.0.7", 3);
        map.put("192.168.0.8", 2);
        map.put("192.168.0.9", 1);
        map.put("192.168.0.10", 2);
    }
}
