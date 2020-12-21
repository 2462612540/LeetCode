package 复现代码;

/**
 * @Classname 翻转链表I
 * @Description TODO
 * @Date 2020/12/21 12:40
 * @Created by xjl
 */
public class 反转链表I {
    public ListNode rever(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode future = curr.next;
            curr.next = pre;
            pre = curr;
            curr = future;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
