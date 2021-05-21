package 计算机程序算法分类.双指针问题;

import org.junit.Test;

/**
 * @Classname 前面k个数
 * @Description TODO
 * @Date 2021/5/20 20:59
 * @Created by xjl
 */
public class 前面k个数 {
    public int getKthMagicNumber(int k) {
        if (k == 0) {
            return 1;
        }
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] array = new int[k];
        array[0] = 1;
        for (int i = 1; i < k; i++) {
            array[i] = Math.min(array[index2] * 3, Math.min(array[index3] * 5, array[index5] * 7));
            if (array[i] == array[index2] * 3) {
                index2++;
            }
            if (array[i] == array[index3] * 5) {
                index3++;
            }
            if (array[i] == array[index5] * 7) {
                index5++;
            }
        }
        return array[k - 1];
    }

    @Test
    public void test(){
        int kthMagicNumber = getKthMagicNumber(5);
        System.out.println(kthMagicNumber);
    }
}
