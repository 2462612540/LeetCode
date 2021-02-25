/**
 * Copyright (C), 2018-2020
 * FileName: 优先队列
 * Author:   xjl
 * Date:     2020/9/4 21:14
 * Description:
 */
package 计算机程序算法分类.工具类;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列是不同于先进先出队列的另一种队列。每次从队列中取出的是具有最高优先权的元素。
 * 如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，
 * 也就是数字默认是小的在队列头，字符串则按字典序排列。
 */
public class 优先队列 {

    private String name;
    private int population;

    public 优先队列(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return this.name;
    }

    public int getPopulation() {
        return this.population;
    }

    public String toString() {
        return getName() + " - " + getPopulation();
    }

    public static void main(String args[]) {
        Comparator<优先队列> OrderIsdn = new Comparator<优先队列>() {
            public int compare(优先队列 o1, 优先队列 o2) {
                // TODO Auto-generated method stub
                int numbera = o1.getPopulation();
                int numberb = o2.getPopulation();
                if (numberb > numbera) {
                    return 1;
                } else if (numberb < numbera) {
                    return -1;
                } else {
                    return 0;
                }

            }
        };
        Queue<优先队列> priorityQueue = new PriorityQueue<优先队列>(11, OrderIsdn);
        优先队列 t1 = new 优先队列("t1", 1);
        优先队列 t3 = new 优先队列("t3", 3);
        优先队列 t2 = new 优先队列("t2", 2);
        优先队列 t4 = new 优先队列("t4", 0);
        priorityQueue.add(t1);
        priorityQueue.add(t3);
        priorityQueue.add(t2);
        priorityQueue.add(t4);
        System.out.println(priorityQueue.poll().toString());
    }
}
