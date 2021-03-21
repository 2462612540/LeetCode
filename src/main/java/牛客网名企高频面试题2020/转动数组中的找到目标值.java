package 牛客网名企高频面试题2020;

/**
 * @Classname 转动数组中的找到目标值
 * @Description TODO
 * @Date 2020/12/17 14:51
 * @Created by xjl
 */
public class 转动数组中的找到目标值 {

    public int search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
