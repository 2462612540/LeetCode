package 计算机程序算法分类.字符串类型;

import org.junit.Test;

/**
 * @Classname 转换小写字母709
 * @Description TODO 采用的双指针的思想来遍历的字符串
 * @Date 2021/6/28 15:03
 * @Created by xjl
 */
public class 转换小写字母709 {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    @Test
    public void test() {
        String hello = toLowerCase3("PiTAs");
        System.out.println(hello);
    }

    public String toLowerCase2(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 32;
            }
        }
        return new String(array);
    }

    public String toLowerCase3(String str) {
        char[] array = str.toCharArray();
        int start=0;
        int end=array.length-1;

        while (start<=end){
            if (array[start] >= 'A' && array[start] <= 'Z') {
                array[start] += 32;
            }
            if (array[end] >= 'A' && array[end] <= 'Z') {
                array[end] += 32;
            }
            start++;
            end--;
        }
        return new String(array);
    }
}
