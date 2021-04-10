package 牛客网名企面试笔试代码复现2021;

/**
 * @Classname 二分查找
 * @Description TODO
 * @Date 2021/4/10 19:35
 * @Created by xjl
 */
public class 二分查找 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return -1;
    }
}
