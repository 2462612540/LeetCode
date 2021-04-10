package leetode每日一题;

/**
 * @Classname 剑指Offer11旋转数组的最小数字
 * @Description TODO
 * @Date 2021/4/10 13:31
 * @Created by xjl
 */
public class 剑指Offer11旋转数组的最小数字 {
    /**
     * @description TODO 使用的是O(n)
     * @param: numbers
     * @date: 2021/4/10 13:34
     * @return: int
     * @author: xjl
     */
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            min = min < numbers[i] ? min : numbers[i];
        }
        return min;
    }

    /**
     * @description TODO 使用的是的二分法的（n/2）这是的一个新的二分查找的思想
     * @param: numbers
     * @date: 2021/4/10 13:33
     * @return: int
     * @author: xjl
     */
    public int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    /**
     * @description TODO 有重复数字的旋转数组来实现的原理 最好的是logn 最坏的情况是是的O（N）
     * @param: numbers
     * @date: 2021/4/10 14:23
     * @return: int
     * @author: xjl
     */
    public int minArray3(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        if (right == 0) {
            return numbers[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] == numbers[right]) {
                right--;
            }
        }
        return numbers[left];
    }
}
