package 牛客网名企高频面试题;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Classname 三个数的最大的乘积
 * @Description TODO
 * @Date 2020/12/10 16:42
 * @Created by xjl
 */
public class 三个数的最大的乘积 {

    public long solve(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        BigDecimal max1 = new BigDecimal(A[len - 1]).multiply(new BigDecimal(A[len - 2])).multiply(new BigDecimal(A[len - 3]));
        BigDecimal max2 = new BigDecimal(A[len - 1]).multiply(new BigDecimal(A[1])).multiply(new BigDecimal(A[0]));
        //最大的三个数只可能是的最后的三个数和最后一个数前面的两个数
        if (max1.compareTo(max2) > 0) {
            return Long.valueOf(max1.toString());
        } else {
            return Long.valueOf(max2.toString());
        }
    }

    @Test
    public void test() {
        long res = solve(new int[]{3472, 7789, 7955, -7098, -9281, 6101, 5051, 7778, 3090, 7423,
                -7151, 5652, 1595, -8094, 677, -8324, 8347, -2482, 9313, -9338, -3157, 8559, 6945, 3618, 3087, 121,
                -8468, 3225, 1356, 6939, 2799, -7231, -6309, -5453, 633, -8689, -4776,
                2714, -2743, -1409, 5918, -3333, 1803, 8330, -2206, -6117, -4486, -7903,
                -4375, -3739, 2897, 8056, -5864, -522, 7451, -4541, -2813, 5790, -532, -6517, 925});
        System.out.println(res);
    }
}
