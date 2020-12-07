/**
 * Copyright (C), 2018-2020
 * FileName: 合并所有的重叠区间
 * Author:   xjl
 * Date:     2020/10/9 9:39
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 合并所有的重叠区间 {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() < 2){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start != o2.start ? o1.start - o2.start : o2.end - o1.end;
            }
        });
        ArrayList<Interval> res = new ArrayList<>();
        //第一个放入
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (res.get(res.size() - 1).start == intervals.get(i).start){
                continue;
            }
            if (res.get(res.size() - 1).end < intervals.get(i).start){
                res.add(intervals.get(i));
            }else {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            }
        }
        return res;
    }

    @Test
    public void test() {
        Interval a = new Interval(10, 30);
        Interval e = new Interval(10, 70);
        Interval b = new Interval(20, 60);
        Interval c = new Interval(80, 100);
        Interval d = new Interval(150, 180);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        ArrayList<Interval> res = merge(list);

        for (Interval re : res) {
            System.out.println(re.start + " " + re.end);
        }
    }

}
