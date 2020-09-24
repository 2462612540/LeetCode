/**
 * Copyright (C), 2018-2020
 * FileName: 数组的交集
 * Author:   xjl
 * Date:     2020/9/20 10:36
 * Description:
 */
package 归并问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] ans = intersect(nums1, nums2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    /**
     * 采用的是list的性质
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        ArrayList<Integer> list = new ArrayList<>();

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 利用的归并的思想来实现的交集
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[nums1.length + nums2.length];
        int index = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                res[index++] = nums2[p2];
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                res[index++] = nums1[p1];
                p1++;
            } else {
                list.add(nums1[p1]);
                res[index++] = nums1[p1++];
                res[index++] = nums2[p2++];
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 利用的是hashmap的存储表示的数字和出现的次数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 采用的是list的性质
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect3(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<Integer> res = new ArrayList<>();
        for (int i : list1) {
            if (list2.contains(i)) {
                res.add(i);
                list2.remove(list2.indexOf(i));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
