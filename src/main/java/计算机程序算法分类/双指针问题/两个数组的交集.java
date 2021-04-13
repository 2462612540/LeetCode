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
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //把list转化为数组
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
