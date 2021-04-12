package 计算机程序算法分类.双指针问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 两个数组的交集
 * @Description TODO
 * @Date 2021/4/12 21:18
 * @Created by xjl
 */
public class 两个数组的交集 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 先对两个数组进行排序
        Arrays.sort(nums1);//时间复杂度为O(nlog(n))
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        //存放的结果
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                // 如果i指向的值小于j指向的值，，说明i指向
                // 的值小了，i往后移一步
                i++;
            } else if (nums1[i] > nums2[j]) {
                // 如果i指向的值大于j指向的值，说明j指向的值
                // 小了，j往后移一步
                j++;
            } else {
                // 如果i和j指向的值相同，说明这两个值是重复的，
                // 把他加入到集合list中，然后i和j同时都往后移一步
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //把list转化为数组
        int index = 0;
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }
}
