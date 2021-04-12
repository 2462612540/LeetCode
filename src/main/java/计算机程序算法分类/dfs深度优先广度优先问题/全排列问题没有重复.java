package 计算机程序算法分类.dfs深度优先广度优先问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 全排列问题没有重复 就是的result(结果) 、string（原始字符串）、vis（访问标志位）、str（新的字符创或者是使用额new Stringbuilder）、 index(开始访问的位置)
 * @Description TODO
 * @Date 2021/4/11 15:14
 * @Created by xjl
 */
public class 全排列问题没有重复 {

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> ss : permute) {
            for (int s : ss) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    //没有重复的
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int index = 0;
        boolean[] vis = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(result, list, index, nums, vis);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int index, int[] nums, boolean[] vis) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]==false){
                    vis[i]=true;
                    list.add(nums[i]);
                    dfs(result, list, index + 1, nums,vis);
                    list.remove(list.size() - 1);
                    vis[i]=false;
                }
            }
        }
    }
}
