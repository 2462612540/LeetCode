/**
 * Copyright (C), 2018-2020
 * FileName: EntryNodeOfLoop
 * Author:   xjl
 * Date:     2020/5/10 10:05
 * Description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 */
package 牛客网练习题;

public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode pre = pHead;
        ListNode curr = pHead.next.next;
        return null;
    }
}
