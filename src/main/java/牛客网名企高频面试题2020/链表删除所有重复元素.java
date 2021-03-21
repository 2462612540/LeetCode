package 牛客网名企高频面试题2020;

import org.junit.Test;

/**
 * @Classname 链表删除所有重复元素
 * @Description TODO
 * @Date 2020/12/18 10:03
 * @Created by xjl
 */
public class 链表删除所有重复元素 {
    /**
     * @description TODO 删除的是的链表的重复的元素
     * @param: head
     * @date: 2020/12/18 10:04
     * @return: ListNode
     * @author: xjl
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;

        ListNode pre = dumy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode future = curr.next;
            if (future.val != curr.val) {
                pre = pre.next;
                curr = curr.next;
            } else {
                while (future != null && future.val == curr.val) {
                    future = future.next;
                }
                pre.next = future;
                curr = future;
            }
        }
        return dumy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode future = curr.next;
                while (future != null && future.val == curr.val) {
                    future = future.next;
                }
                prev.next = future;
                curr = future;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;

        ListNode res = deleteDuplicates(node1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
