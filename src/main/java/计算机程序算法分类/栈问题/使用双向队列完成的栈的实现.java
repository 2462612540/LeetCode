package 计算机程序算法分类.栈问题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname 使用双向队列完成的栈的实现
 * @Description TODO
 * @Date 2021/5/19 15:34
 * @Created by xjl
 */
public class 使用双向队列完成的栈的实现 {

    public static void main(String[] args) {
       Deque<Integer> queue=new ArrayDeque<>();//这个是双向链表
       queue.add(1);
       queue.add(2);
       queue.add(3);

       while (!queue.isEmpty()){
           System.out.println(queue.pollLast());
       }

    }


}
