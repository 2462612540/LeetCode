package 牛客网名企面试笔试问题2021;

import java.util.Arrays;

/**
 * @Classname 只出现一次的数字
 * @Description TODO
 * @Date 2021/2/27 11:48
 * @Created by xjl
 */
public class 只出现一次的数字 {
    public int foundOnceNumber(int[] arr, int k) {
        Arrays.sort(arr);
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i]==arr[i+1]){
                i += k-1;
            }else{
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }
}
