package 名企高频面试题143;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 所有的子集
 * @Description TODO
 * @Date 2020/12/15 21:06
 * @Created by xjl
 */
public class 所有的子集 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
