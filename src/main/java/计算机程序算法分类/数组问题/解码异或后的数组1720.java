package 计算机程序算法分类.数组问题;

import 牛客网练习题.Solution;

/**
 * @Classname 解码异或后的数组1720
 * @Description TODO
 * @Date 2021/5/6 10:34
 * @Created by xjl
 */
public class 解码异或后的数组1720 {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
