/**
 * Copyright (C), 2018-2020
 * FileName: 判断链表是否有环
 * Author:   xjl
 * Date:     2020/9/13 19:25
 * Description:
 */
package 牛客面试必会100题;

public class 判断链表环的入口 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                //表示有环了 去判断环的入口
                fast = head;
                while (fast != low) {
                    fast = fast.next;
                    low = low.next;
                }
                return fast;
            }
        }
        //表示没有环
        return null;
    }
}
