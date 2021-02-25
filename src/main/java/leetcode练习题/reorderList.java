/**
 * Copyright (C), 2018-2020
 * FileName: reorderList
 * Author:   xjl
 * Date:     2020/8/12 21:58
 * Description: 143. 重排链表
 */
package leetcode练习题;

import java.util.ArrayDeque;
import java.util.Deque;

public class reorderList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //设置一个栈空间
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        //将所有的节点都放置在栈中
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr=head;
        ListNode stack_curr=new ListNode(Integer.MAX_VALUE);
        while (curr.next!=stack_curr.next){
            stack_curr=stack.poll();
            stack_curr.next=curr.next;
            curr.next=stack_curr;
            curr=curr.next.next;
        }
        stack_curr.next=null;
    }
}
