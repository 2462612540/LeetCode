package 计算机程序算法分类.数组问题;

/**
 * @Classname 数组的旋转
 * @Description TODO
 * @Date 2021/4/13 14:19
 * @Created by xjl
 */
public class 数组的旋转 {
    /**
     * @description TODO 使用临时数组解决
     * @param: nums
     * @param: k
     * @date: 2021/4/13 14:20
     * @return: void
     * @author: xjl
     */
    public void rotate(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        // 把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        // 然后在把临时数组的值重新放到原数组，
        // 并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        //先反转全部的元素
        reverse(nums, 0, length - 1);
        //在反转前k个元素
        reverse(nums, 0, k - 1);
        //接着反转剩余的
        reverse(nums, k, length - 1);
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
