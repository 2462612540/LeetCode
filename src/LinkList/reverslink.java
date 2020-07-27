/**
 * Copyright (C), 2018-2020
 * FileName: reverslink
 * Author:   xjl
 * Date:     2020/7/16 14:36
 * Description: 翻转链表
 */
package LinkList;

import org.junit.Test;

public class reverslink {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode revers(ListNode head) {
       ListNode pre=null;
       ListNode curr=head;
       while (curr!=null){
           ListNode next=curr.next;
           curr.next=pre;
           pre=curr;
           curr=next;
       }
       return pre;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(8);
        ListNode s4 = new ListNode(7);
        ListNode s5 = new ListNode(0);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        ListNode revers = revers(s1);

        //输入结果
        while (revers != null) {
            System.out.print(revers.val + " ");
            revers = revers.next;
        }
    }
}
