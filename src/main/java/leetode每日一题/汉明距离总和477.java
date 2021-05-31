package leetode每日一题;

/**
 * @Classname 汉明距离总和477
 * @Description TODO
 * @Date 2021/5/28 9:10
 * @Created by xjl
 */
public class 汉明距离总和477 {
    /**
     * @description TODO
     * @param: nums
     * @date: 2021/5/28 9:11
     * @return: int
     * @author: xjl
     */
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return sum;
    }

    public int totalHammingDistance2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

}
