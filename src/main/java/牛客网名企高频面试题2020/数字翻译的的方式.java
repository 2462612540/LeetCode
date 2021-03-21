package 牛客网名企高频面试题2020;

/**
 * @Classname 名企高频面试题143.数字翻译的的方式
 * @Description TODO
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 现在给一串数字，返回有多少种可能的译码结果
 * @Date 2020/12/7 14:15
 * @Created by xjl
 */
public class 数字翻译的的方式 {

    public int solve(String nums) {
        return back(nums.toCharArray(), 0);
    }

    // 递归函数  将大问题化解为小问题
    public int back(char[] nums, int start) {
        //当start走到终点时，证明已经解码完毕，直接返回1
        if (start == nums.length) {
            return 1;
        }
        //当字符为0的时候，0没对应的解码，所以直接返回0 (此路解码废掉)
        if (nums[start] == '0')
            return 0;
        //每次解码一个字符
        int res1 = back(nums, start + 1);
        int res2 = 0;
        //如果当前字符等于1 或者当前字符加上下一个字符合起来小于等于26 则可以一次解码两个字符
        if ((start < nums.length - 1) && (nums[start] == '1' || ((nums[start] - '0') * 10 + (nums[start + 1] - '0') <= 26))) {
            res2 = back(nums, start + 2);
        }
        //返回结果
        return res1 + res2;
    }
}
