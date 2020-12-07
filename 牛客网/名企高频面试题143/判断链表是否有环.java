package 名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.判断链表是否有环
 * Author:   xjl
 * Date:     2020/9/13 19:25
 * Description:
 */


public class 判断链表是否有环 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            //快慢指针的效果
            fast = fast.next.next;
            low = low.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }
        }
        return false;
    }

}
