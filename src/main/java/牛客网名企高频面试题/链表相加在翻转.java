package 牛客网名企高频面试题;

/**
 * @Classname 链表相加在翻转
 * @Description TODO
 * @Date 2020/12/16 12:16
 * @Created by xjl
 */
public class 链表相加在翻转 {
    /**
     * @description TODO  链表的相加的原理
     * @param: head1
     * @param: head2
     * @date: 2020/12/16 12:18
     * @return: 名企高频面试题143.链表相加在翻转.ListNode
     * @author: xjl
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val = carry;
            if (head1 != null) {
                val += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                val += head2.val;
                head2 = head2.next;
            }
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(head.next);
    }

    /**
     * @description TODO 链表的翻转过程
     * @param: head
     * @date: 2020/12/16 12:17
     * @return: 名企高频面试题143.链表相加在翻转.ListNode
     * @author: xjl
     */
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
