package 计算机程序算法分类.链表问题;

import 牛客网练习题.Solution;

import java.util.LinkedList;

/**
 * @Classname 判断联表示是否有环问题
 * @Description TODO
 * @Date 2021/3/26 21:26
 * @Created by xjl
 */
public class 判断联表示是否有环问题 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /***
     * @description TODO 这样的也是是双链表的一种的方式
     * @param: head
     * @date: 2021/3/26 21:34
     * @return: boolean
     * @author: xjl
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description TODO 这也是一种双链表的形式的
     * @param: head
     * @date: 2021/3/26 21:35
     * @return: boolean
     * @author: xjl
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
