package 牛客网名企高频面试题2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Classname 有重复的数字的排列
 * @Description TODO
 * @Date 2020/12/17 10:15
 * @Created by xjl
 */
public class 有重复的数字的排列 {

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> res = permuteUnique(new int[]{1, 3, 2});
        for (ArrayList<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        boolean[] vis = new boolean[num.length];
        dfs(num, list, vis, ans);
        return ans;
    }

    private void dfs(int[] num, ArrayList<Integer> list, boolean[] vis, ArrayList<ArrayList<Integer>> ans) {
        if (list.size() == num.length && !ans.contains(list)) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!vis[i]) {
                list.add(num[i]);
                vis[i] = true;
                dfs(num, list, vis, ans);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
