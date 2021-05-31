package leetode每日一题;

/**
 * @Classname tow幂
 * @Description TODO
 * @Date 2021/5/30 22:20
 * @Created by xjl
 */
public class tow幂231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else {
            n = n > 0 ? n : -1 * n;
            return n % 2 == 0 ? true : false;
        }
    }
    /**
     * @description TODO 采用的是二分方法
     * @param: n
     * @date: 2021/5/31 9:02
     * @return: boolean
     * @author: xjl
    */
    public boolean isPowerOfTwo2(int n) {
        if (n < 1) {
            return false;
        }
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            double result = Math.pow(2, mid);
            if (result == n) {
                return true;
            } else if (result < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return false;
    }
}
