/**
 * Copyright (C), 2018-2020
 * FileName: getIntersectionNode0207
 * Author:   xjl
 * Date:     2020/8/12 19:40
 * Description:
 */
package leetcode练习题;

public class getIntersectionNode0207 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路：双指针法。一个指针指向A链表，一个指向B链表。如果相遇则返回，否则没有交点。
        //如果存在相交结点，那么pA和pB一定会相遇。
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
