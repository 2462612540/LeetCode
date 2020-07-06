/**
 * Copyright (C), 2018-2020
 * FileName: continuousSet
 * Author:   xjl
 * Date:     2020/7/5 16:44
 * Description: 排序算法
 */
package Sort;

import org.junit.Test;

import java.util.*;

public class continuousSet {
    //通过率64
    public boolean[] continuousSet(int[] mSet) {
        //返回的结果
        boolean[] result = new boolean[mSet.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < mSet.length; i++) {
            //添加元素
            list.add(mSet[i]);
            //选择第一个
            int start = Collections.min(list);
            int end = Collections.max(list);
            int flag = 0;
            //检查是否有序
            while (start <= end) {
                if (!list.contains(start)) {
                    flag = 1;
                    break;
                } else {
                    start++;
                }
            }
            if (flag == 1) {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }
        return result;
    }
    //通过率72%
    public boolean[] continuousSet2(int[] mSet) {
        //返回的结果
        boolean[] result = new boolean[mSet.length];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < mSet.length; i++) {
            //添加元素
            set.add(mSet[i]);
            //选择第一个
            int start = set.first();
            int end = set.last();
            int flag = 0;
            //检查是否有序
            while (start <= end) {
                if (!set.contains(start)) {
                    flag = 1;
                    break;
                } else {
                    start++;
                }
            }
            if (flag == 1) {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }
        return result;
    }
    //通过率100%
    public boolean[] continuousSet3 (int[] mSet) {
        // write code here
        boolean[] res=new boolean[mSet.length];
        if(mSet.length==0) return res;

        Set<Integer> set=new HashSet<>();
        int min=mSet[0];
        int max=mSet[0];
        for(int i=0;i<mSet.length;i++){
            max=Math.max(max,mSet[i]);
            min=Math.min(min,mSet[i]);
            if(set.add(mSet[i])){
                res[i]=(max-min+1==set.size());
            }else{
                res[i]=res[i-1];
            }
        }
        return res;
    }
    @Test
    public void test() {

        int[] array = {2, 1, 0, 4, 1, 0, 3, 4, 0, 2};

        boolean[] booleans = continuousSet2(array);

        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);
        }
    }
}
