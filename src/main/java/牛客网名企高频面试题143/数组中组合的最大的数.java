package 牛客网名企高频面试题143;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @Classname 数组中组合的最大的数
 * @Description TODO
 * @Date 2020/12/10 19:57
 * @Created by xjl
 */
public class 数组中组合的最大的数 {

    @Test
    public void test() {
        String solve = solve(new int[]{30, 1});
        System.out.println(solve);
    }

    public String solve(int[] nums) {
        //判断数组的安全
        if (nums.length == 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<BigDecimal> ans = new ArrayList<>();
        BigDecimal maxnum = new BigDecimal(0);
        boolean[] vis = new boolean[nums.length];
        dfs(nums, list, result, vis);
        for (ArrayList<Integer> a : result) {
            String res = "";
            for (int i : a) {
                res += String.valueOf(i);
            }
            maxnum = maxnum.compareTo(new BigDecimal(res)) > 0 ? maxnum : new BigDecimal(res);
        }
        return maxnum.toString();
    }

    private void dfs(int[] nums, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, boolean[] vis) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                list.add(nums[i]);
                vis[i] = true;
                //下一个状态
                dfs(nums, list, result, vis);
                //回溯 剪枝
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }

}
