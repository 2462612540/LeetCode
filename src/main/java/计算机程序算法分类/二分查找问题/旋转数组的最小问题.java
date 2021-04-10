package 计算机程序算法分类.二分查找问题;

/**
 * @Classname 二分查找问题
 * @Description TODO
 * @Date 2021/4/10 14:29
 * @Created by xjl
 */
public class 旋转数组的最小问题 {
    public int minArray(int[] numbers) {
        int left = 0;
        int riht = numbers.length - 1;
        if (riht == 0) return numbers[0];
        while (left < riht) {
            int mid = left + (riht - left) / 2;
            if (numbers[mid] > numbers[riht]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[riht]) {
                riht = mid;
            } else if (numbers[mid] == numbers[riht]) {
                riht--;
            }
        }
        return numbers[left];
    }
}
