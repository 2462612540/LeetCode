package 计算机程序算法分类.双指针问题;

import java.util.*;

/**
 * @Classname 两个数组的交集
 * @Description TODO
 * @Date 2021/4/12 21:18
 * @Created by xjl
 */
public class 两个数组的交集 {
    /**
     * @description TODO  采用的是的双指针来实现 这个题目是知识保留一份的结果
     * @param: nums1
     * @param: nums2
     * @date: 2021/4/13 14:05
     * @return: int[]
     * @author: xjl
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 先对两个数组进行排序
        Arrays.sort(nums1);//时间复杂度为O(nlog(n))
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        //存放的结果
        HashSet<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * @description TODO  这个题目是知识保留一份的结果
     * @param: nums1
     * @param: nums2
     * @date: 2021/4/13 14:41
     * @return: int[]
     * @author: xjl
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            if (list.contains(i)&&!result.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * @description TODO  采用的是的双指针来实现 保留所有的重复的结果
     * @param: nums1
     * @param: nums2
     * @date: 2021/4/13 14:05
     * @return: int[]
     * @author: xjl
     */
    public int[] intersect_2(int[] nums1, int[] nums2) {
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
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }
}
