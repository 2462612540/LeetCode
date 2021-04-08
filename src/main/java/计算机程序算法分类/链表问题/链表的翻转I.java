package 计算机程序算法分类.链表问题;

import leetcode练习题.reverse;

import java.util.List;

/**
 * @Classname 链表的翻转I
 * @Description TODO
 * @Date 2021/4/8 14:35
 * @Created by xjl
 */
public class 链表的翻转I {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head==null)return head;
        ListNode pre=null;
        ListNode curr=head;

        while (curr!=null){
            ListNode future=curr.next;
            curr.next=pre;
            pre=curr;
            curr=future;
        }
        return pre;
    }
}
