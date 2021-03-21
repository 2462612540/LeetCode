package 牛客网名企高频面试题2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname 随机找到数据流中位数
 * @Description TODO
 * @Date 2020/12/8 16:30
 * @Created by xjl
 */
public class 随机找到数据流中位数 {

    public double[] flowmedian(int[][] operations) {
        ArrayList<Double> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] arr : operations) {
            if (arr[0] == 1) {
                //存元素
                list.add(arr[1]);
            } else {
                Collections.sort(list);
                if (list.size() == 0) {
                    result.add((double) -1);
                    continue;
                }
                if (list.size() % 2 != 0) {
                    result.add((double) list.get(list.size() / 2));
                } else {
                    result.add((double) (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2);
                }
            }
        }
        return result.stream().mapToDouble(Double::valueOf).toArray();
    }

    @Test
    public void test() {
        //{{1, 5}, {2}, {1, 3}, {2}, {1, 6}, {2}, {1, 7}, {2}}  {{2}, {1, 1}, {2}}
        double[] flowmedian = flowmedian1(new int[][]{{1, 5}, {2}, {1, 3}, {2}, {1, 6}, {2}, {1, 7}, {2}});
//        for (double a : flowmedian) {
//            System.out.println(a);
//        }
    }

    /**
     * @description TODO 采用的是大跟堆和小根堆
     * @param: operations
     * @date: 2020/12/8 19:04
     * @return: double[]
     * @author: xjl
     */
    public double[] flowmedian1(int[][] operations) {
        int sum = 0;
        PriorityQueue<Integer> queMax = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        PriorityQueue<Integer> queMin = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        List<Double> resD = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 1) {
                //插入
                int number = operations[i][1];
                sum++;
                queMax.add(number);
                queMin.add(queMax.poll());
                if (sum % 2 == 1) {
                    queMax.add(queMin.poll());
                }
            } else {
                //查找
                if (sum == 0) {
                    resD.add((double) -1);
                } else {
                    if (sum % 2 == 1) {
                        //res.add((double)-1);
                        double dt = queMax.peek();
                        resD.add(dt);
                    } else {
                        //res.add(getMidNum(temD));
                        double dt = (queMax.peek() + queMin.peek()) / 2.0;
                        resD.add(dt);
                    }
                }

            }
        }

        while (!queMax.isEmpty()) {
            System.out.print(queMax.poll() + " ");
        }
        System.out.println();
        System.out.println("-------------------------------");
        while (!queMin.isEmpty()) {
            System.out.print(queMin.poll() + " ");
        }

        double[] res = new double[resD.size()];
        for (int i = 0; i < resD.size(); i++) {
            res[i] = resD.get(i);
        }
        return res;
    }
}
