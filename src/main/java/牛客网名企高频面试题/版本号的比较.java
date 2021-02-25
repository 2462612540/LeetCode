package 牛客网名企高频面试题;

import org.junit.Test;

/**
 * @Classname 版本号的比较
 * @Description TODO
 * @Date 2020/12/11 14:28
 * @Created by xjl
 */
public class 版本号的比较 {

    public int compare(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            int a = arr1[index1] != null ? Integer.valueOf(arr1[index1]) : 0;
            int b = arr2[index2] != null ? Integer.valueOf(arr2[index2]) : 0;
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            index1++;
            index2++;
        }
        if (index1 == arr1.length && index2 < arr2.length) {
            return -1;
        } else if (index2 == arr2.length && index1 < arr1.length) {
            return 1;
        }
        return 0;
    }

    @Test
    public void test() {
        int res = compare("241.169.214.43.45.253", "241.169.214.43.45.253");
        System.out.println(res);
    }
}
