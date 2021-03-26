package testcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname AttendMeetings
 * @Description TODO
 * @Date 2021/3/24 15:16
 * @Created by xjl
 */
public class AttendMeetings {

    @Test
    public void test(){
        int[][] times={{9,11},{10,12},{14,16},{14,15}};
        int i = AttendMeetings(times);
        System.out.println(i);
    }


    public int AttendMeetings(int[][] times) {
        if (times.length == 0) {
            return 0;
        }
        int[][] merge = merge(times);
        return merge.length;
    }

    //合并区间的方法
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged=new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            int L=intervals[i][0],R=intervals[i][1];
            if (merged.size()==0||merged.get(merged.size()-1)[1]<L){
                merged.add(new int[]{L,R});
            }else {
                if (merged.get(merged.size()-1)[1]>L){
                    merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);
                }else {
                    merged.add(new int[]{L,R});
                }
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
