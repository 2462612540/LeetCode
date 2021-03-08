package 牛客网名企面试笔试问题2021;

import java.util.List;

/**
 * @Classname 链表的翻转
 * @Description TODO
 * @Date 2021/3/8 12:21
 * @Created by xjl
 */
public class 链表的翻转 {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode future = curr.next;
            curr.next = pre;
            pre.next = curr;
            curr.next = future;
        }
        return pre;
    }
}
