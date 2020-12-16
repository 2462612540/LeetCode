package 名企高频面试题143;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Classname 目标值的和
 * @Description TODO
 * @Date 2020/12/16 10:55
 * @Created by xjl
 */
public class 目标值的和 {

    /**
     * @description TODO
     * @param: num
     * @param: target
     * @date: 2020/12/16 10:55
     * @return: java.util.ArrayList<java.util.ArrayList < java.lang.Integer>>
     * @author: xjl
     */
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> ans = combinationSum3(new int[]{100, 10, 20, 70, 60, 10, 50}, 80);
        for (ArrayList<Integer> lists : ans) {
            for (int i : lists) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum3(int[] num, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[num.length];
        Arrays.sort(num);
        dfs(num, 0, target, list, vis);
        return ans;
    }

    private void dfs(int[] num, int index, int target, ArrayList<Integer> list, boolean[] vis) {
        //保证的是剪枝的情况
        if (target < 0) {
            return;
        }
        //终止条件
        if (target == 0 && !ans.contains(list)) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (vis[i] == false) {
                //这个状态
                list.add(num[i]);
                vis[i] = true;
                //下一个转态
                dfs(num, i + 1, target - num[i], list, vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
