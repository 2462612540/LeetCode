package 计算机程序算法分类.链表问题;

import 牛客网练习题.Solution;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname 从尾到头打印链表
 * @Description TODO
 * @Date 2021/3/26 16:47
 * @Created by xjl
 */
public class 从尾到头打印链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @description TODO  采用的是常规的思路
     * @param: head
     * @date: 2021/3/26 17:05
     * @return: int[]
     * @author: xjl
     */
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode res = reverselist(head);
        while (res != null) {
            list.add(res.val);
            res = res.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private ListNode reverselist(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * @description TODO 采用的栈的结构来实现 栈是一种先进先出的数据结构
     * @param: head
     * @date: 2021/3/26 16:54
     * @return: int[]
     * @author: xjl
     */
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    /**
     * @description TODO  就是数组倒序的存储思路
     * @param: head
     * @date: 2021/3/26 16:58
     * @return: int[]
     * @author: xjl
     */
    public static int[] reversePrint4(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        int[] num = new int[count];

        while (head != null) {
            num[count--] = head.val;
            head = head.next;
        }
        return num;
    }
}
