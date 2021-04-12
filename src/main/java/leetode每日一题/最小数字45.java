package leetode每日一题;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname 最小数字45
 * @Description TODO
 * @Date 2021/4/12 11:23
 * @Created by xjl
 */
public class 最小数字45 {

    @Test
    public void test(){
        String s = minNumber(new int[]{3,30,34,5,9});
        System.out.println(s);
    }

    public String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
