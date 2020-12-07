/**
 * Copyright (C), 2018-2020
 * FileName: K个不同的整数的子数组992
 * Author:   xjl
 * Date:     2020/9/5 19:13
 * Description:
 */
package 滑动窗口问题集合;

public class K个不同的整数的子数组992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        //统计整数出现次数
        int[] numStat = new int[A.length + 1];
        //[start, end]
        int start = 0, end = 0, numCount = 0, goodCount = 0;
        while (end < A.length) {
            int num = A[end];
            numStat[num]++;
            if (numStat[num] == 1) numCount++;//新出现的数字
            while (numCount > K) {
                int n = A[start];
                numStat[n]--;
                if (numStat[n] == 0) numCount--;//肯定有 numCount==K
                start++;
            }
            //每次end结算一次，找出所有匹配的start，此时[start,end]肯定是合法的
            if (numCount == K) {
                int oldStart = start;
                //每个start结算一次
                while (numCount == K) {
                    goodCount++;//关键代码
                    //System.out.println(Arrays.toString(Arrays.copyOfRange(A, start, end+1)));//[start, end]
                    int n = A[start];
                    start++;
                    numStat[n]--;
                    if (numStat[n] == 0) numCount--;//肯定有 numCount==K-1
                }
                //start恢复到oldStart, numStat也恢复
                //while(numCount > K)//效果一样的条件
                while (start > oldStart) {
                    start--;
                    int n = A[start];
                    numStat[n]++;
                    if (numStat[n] == 1) numCount++;//肯定有 numCount==K
                }
            }
            end++;
        }
        return goodCount;
    }
}
