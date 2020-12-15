package 名企高频面试题143;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 最长子数组长度k
 * @Description TODO
 * @Date 2020/12/13 21:56
 * @Created by xjl
 */
public class 最长子数组长度k {
    /**
     * @description TODO 定义一个HashMap，其中key是sum值，value为sum值最早出现的位置
     * @param: arr
     * @param: k
     * @date: 2020/12/13 22:07
     * @return: int
     * @author: xjl
     */
    public int maxlenEqualK(int[] arr, int k) {
        if (arr.length == 0) return 0;
        int len = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // 处理边界值
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //只记录第一次的位置，因为要求最长数组
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            //判断是否需要更新len
            if (map.containsKey(sum - k) && i - map.get(sum - k) > len) {
                len = i - map.get(sum - k);
            }
        }
        return len;
    }
}
