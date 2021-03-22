package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 嵌套信封问题
 * @Description TODO
 * @Date 2021/3/22 1:22
 * @Created by xjl
 */
public class 嵌套信封问题 {

    @Test
    public void test() {
        int i = maxLetters(new int[][]{{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}});
        System.out.println(i);
    }

    public int maxLetters(int[][] letters) {
        List<int[]> list = new ArrayList<>();
        int len = letters.length;
        for (int i = 0; i < len; i++) {
            list.add(letters[i]);
        }
        // 长度，宽度。长度相同则按宽度，宽度在上的大，负责长度小的在上
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        // 最长上升子序列问题
        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 初始化长度为1
        int ans = 1; // 初始化最大长度为1
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int[] a = list.get(i); // a下边，长大宽大
                int[] b = list.get(j); // b上边，长小宽小
                if (b[1] < a[1] && b[0] < a[0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(dp[i], ans);
                }
                System.out.print(dp[i] + " ");
            }
            System.out.println();
        }
        return ans;
    }
}
