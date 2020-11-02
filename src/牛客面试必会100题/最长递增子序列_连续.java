/**
 * Copyright (C), 2018-2020
 * FileName: 最长递增子序列
 * Author:   xjl
 * Date:     2020/9/29 22:27
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 最长递增子序列_连续 {

    @Test
    public void test() {
        int[] lis = LIS(new int[]{2, 4, 3, 5, 1, 7, 6, 9, 8});
        for (int i : lis) {
            System.out.println(i);
        }
    }

    public int[] LIS(int[] arr) {
        int n = arr.length;
        // 列表的最大子序列
        // 下标从1开始
        int[] end = new int[n + 1];
        // 存储每个元素的最大子序列个数
        int[] dp = new int[n];
        int len = 1;
        //子序列的第一个元素 默认为数组第一个元素
        end[1] = arr[0];
        //第一个元素的最大子序列个数肯定是1
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (end[len] < arr[i]) {
                //当arr[i] > end[len] 时 arr[i]添加到 end后面
                end[++len] = arr[i];
                dp[i] = len;
            } else {
                //当前元素小于end中的最后一个元素 利用二分法寻找第一个大于arr[i]的元素
                //end[l] 替换为当前元素 dp[]
                int l = 0;
                int r = len;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (end[mid] >= arr[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                end[l] = arr[i];
                dp[i] = l;
            }
        }

        int[] res = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }

    /**
     * 这个是完全错误的代码
     *
     * @param num
     * @return
     */
    public int[] LIS2(int[] num) {
        int[] dp = new int[num.length];
        int[] index = new int[num.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < num.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (num[i] > num[j]) {
                    dp[i] = dp[j] + 1;
                    index[i] = num[j];
                    break;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < index.length; i++) {
            if (index[i] > 0 && index[i] < index[i - 1]) {
                list.add(index[i]);
                System.out.print(index[i] + " ");
            }
        }
        Arrays.sort(num);
        list.add(num[num.length - 1]);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
