package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Classname 返回出现的1次的数字
 * @Description TODO
 * @Date 2021/3/9 9:57
 * @Created by xjl
 */
public class 返回出现的1次的数字 {
    /**
     * @description TODO
     * 出现k次就不能再用异或的方法了，因为k(奇数)个相同的数异或还是得到本身。但是还是可以采用位运算的思想，
     * 因为出现k(奇数)次的数字每个位（0或者1）也是出现k(奇数)次，因此可以每一位的和能够被k整除（对k取余为0）。
     * 所以如果把每个数的二进制表示的每一位加起来，对于每一位的和，如果能被k整除，那对应那个只出现一次的数字的那一位就是0，否则对应的那一位是1。
     *
     * 我们需要用一个长度为32（int型二进制表示最多为32位，4字节）的数组bitSum保存每一位的和
     * 具体来讲实现过程是，先初始化为0，然后对于每个数字，遍历它二进制表示的每一位，如果这一位是1，bitSum对应的那一位就加1。
      * @param: arr
     * @param: k
     * @date: 2021/3/9 10:22
     * @return: int
     * @author: xjl
    */
    public int foundOnceNumber3 (int[] arr, int k) {
        // 每个二进制位求和，如果某个二进制位不能被k整除，那么只出现一次的那个数字在这个二进制位上为1。
        int[] binarySum = new int[32];
        for(int i = 0; i< 32; i++){//求每个二进制位的和
            int sum = 0;
            for(int num : arr){
                sum += (num >>i & 1);//依次右移num，同1相与，计算每一位上1的个数
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i< 32; i++){
            if(binarySum[i]%k!=0){
                res += 1<<i;//左移恢复
            }
        }
        return res;
    }

    //采用的是使用的是hashmap 时间是的n
    public int foundOnceNumber2 (int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap();
        for (int i=0;i<arr.length;i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for (int key:map.keySet()){
            if (map.get(key)==1){
                return key;
            }
        }
        return -1;
    }
    /**
     * @description TODO  使用的是的nlogn
     * @param: arr
     * @param: k
     * @date: 2021/3/9 10:17
     * @return: int
     * @author: xjl
    */
    public int foundOnceNumber(int[] arr, int k) {
        if (k > arr.length) return -1;
        Arrays.sort(arr);
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int i = foundOnceNumber2(new int[]{5, 4, 1, 1, 5, 1, 5}, 3);
        System.out.println(i);
    }
}
