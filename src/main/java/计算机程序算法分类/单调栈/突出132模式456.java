package 计算机程序算法分类.单调栈;

import org.junit.Test;

import java.util.Stack;

/**
 * @Classname 突出132模式
 * @Description TODO
 * @Date 2021/3/24 8:53
 * @Created by xjl
 */
public class 突出132模式456 {
    /**
     * @description TODO 采用的是单调栈的一个方法  时间复杂度为o(n)
     * 若 nums数组长度小于 3，直接返回 false（寻找 132 模式），一定不是 132 模式。
     * 将每个元素前面的最小值，放入数组 min 中。
     * 从后往前遍历，首先满足条件 3 > 1（一定满足 3 >= 1，排除 3 = 1 的情况）。
     * while 循环确保条件 2 > 1，只要有 2 <= 1 的情况，直接出栈。
     * 只要栈非空，说明同时满足 3 > 1 且 2 > 1，一旦满足 2 < 3，返回 true
     * 其余情况直接入栈。
     * @param: nums
     * @date: 2021/3/24 9:06
     * @return: boolean
     * @author: xjl
     */
    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        // 第一个位置的最小数肯定就是它自己了
        min[0] = nums[0];
        // 将前一个位置的最小数和当前位置的数比较，找到当前位置的最小数 找到1
        for (int i = 1; i < n; ++i) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        // 从后往前遍历，stack 中的数字表示的是从位置 i 到 n 中，大于 min[i] 且小于 nums[i] 的数
        for (int i = n - 1; i >= 0; --i) {
            //保证的3>1
            if (nums[i] > min[i]) {
                // 如果栈中的数字比 min[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                while (!stack.isEmpty() && stack.peek() <= min[i]) stack.pop();
                // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                if (!stack.isEmpty() && stack.peek() < nums[i]) return true;
                // 不管怎样都要push进来当前的数，因为当前的数满足了大于 min[i]
                stack.push(nums[i]);
            }
        }
        // 到最后都没找到，肯定只能返回false了
        return false;
    }

    /**
     * @description TODO 构建一个的单调递增或者是单调递减的栈   一般中正对于得有这个凸出 和凹陷的一样的函数问题等
     * @param: nums
     * @date: 2021/3/24 9:39
     * @return: boolean
     * @author: xjl
     */
    public boolean find132pattern3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int three = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < three) {
                return true;
            }
            while (!stack.empty() && nums[i] > stack.peek()) {
                three = stack.peek();
                stack.pop();
            }
            //入栈的操作
            stack.push(nums[i]);
        }
        return false;
    }

    /**
     * @description TODO 我先使用的是的最简单的一种方法 但是时间复杂可定是超过时间了O(n^3)
     * @param: nums
     * @date: 2021/3/24 8:54
     * @return: boolean
     * @author: xjl
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] array = {9, 4, 5, 2, 1, 4};
        boolean pattern = find132pattern2(array);
        System.out.println(pattern);
    }
}
