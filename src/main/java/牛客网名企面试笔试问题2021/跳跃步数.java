package 牛客网名企面试笔试问题2021;

import org.junit.Test;

/**
 * @Classname 跳跃步数
 * @Description TODO
 * @Date 2021/3/23 17:01
 * @Created by xjl
 */
public class 跳跃步数 {
    /**
     * @description TODO  给你一个长度为n的数组A。 A[i]表示从i这个位置开始最多能往后跳多少格。求从1开始最少需要跳几次就能到达第n个格子。
     * @param: n   //思路,n为数组长度,A[i]表示i位置最多能往后跳多少格
     * @param: A
     * @date: 2021/3/23 17:02
     * @return: int
     * @author: xjl
     */
    public int Jump(int n, int[] A) {
        int current = 0;                            //当前位置
        int maxStep = 0;                            //最远可跳跃位置
        int stepNum = 0;                            //跳的步数
        for (int i = 0; i < n - 1; ++i) {
            maxStep = Math.max(maxStep, i + A[i]);  //maxStep记录的每次可以达到的最大位置
            if (current >= n) {
                break;                              //当前位置大于长度,表示已经跳完了,出去了
            }
            if (current == i)                       //当前位置等于i时候,表示遍历到了最后一步跳法跳完时候,
            {                                       //当前位置完成一步跳跃之后,等于最远可到达位置,步数加1
                current = maxStep;                  //根据每处的maxStep,将当前位置换成局部最优的
                ++stepNum;
            }
        }
        return stepNum;
    }

    @Test
    public void test() {
        int jump = Jump(3, new int[]{2, 3, 1});
        System.out.println(jump);
    }
}
