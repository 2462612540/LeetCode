package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname 全排列问题
 * @Description TODO
 * @Date 2020/12/11 14:17
 * @Created by xjl
 */
public class 全排列问题 {

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> per = per(new int[]{1, 2, 3});
        for (ArrayList<Integer> a : per) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> per(int[] nums) {
        //检查数组的安全
        if (nums.length == 0) {
            return null;
        }
        boolean[] vis = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums, list, result, vis);
        return result;
    }

    private void dfs(int[] nums, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result, boolean[] vis) {
        //终止条件
        if (list.size() == nums.length) {
            result.add((ArrayList<Integer>) list.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //判断是否访问的记录
            if (!vis[i]) {
                //这一次的状态
                list.add(nums[i]);
                vis[i] = true;
                //下一次的状态
                dfs(nums, list, result, vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
