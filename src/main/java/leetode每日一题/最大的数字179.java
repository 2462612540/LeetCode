package leetode每日一题;

import org.junit.Test;
import 牛客网练习题.Solution;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Classname 最大的数字179 就是一个的重新组合的数字问题
 * @Description TODO
 * @Date 2021/4/12 10:03
 * @Created by xjl
 */
public class 最大的数字179 {

    @Test
    public void test() {
        String s = largestNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        System.out.println("res=" + s);
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String numsToWord[] = new String[n];
        for (int i = 0; i < n; i++) {
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //compareTo()方法比较的时候是按照ASCII码逐位比较的
        //通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        //所以[3,30,34]排序后变为[34,3,30]
        //[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        //如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if (numsToWord[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numsToWord[i]);
        }
        return sb.toString();
    }

    String result = "";

    public String largestNumber2(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        ArrayList<String> list = new ArrayList<>();
        boolean[] vis = new boolean[arr.length];
        //开始访问的位置
        int index = 0;
        dfs(list, vis, index, arr);
        return result;
    }

    private void dfs(ArrayList<String> list, boolean[] vis, int index, String[] arr) {
        //表示遍历完成
        if (index == arr.length) {
            if (list.get(0) != "0") {
                //将list中的数据便成为string
                String res = "";
                for (String s : list) {
                    res += s;
                }
                result = result.compareTo(res) > 0 ? result : res;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (vis[i] == false) {
                    vis[i] = true;
                    list.add(arr[i]);
                    dfs(list, vis, index + 1, arr);
                    //删除的最后的添加来的数字 进行回溯的算法
                    list.remove(list.size() - 1);
                    vis[i] = false;
                }
            }
        }
    }
}
