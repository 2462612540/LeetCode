package 牛客网名企高频面试题复现代码;

/**
 * @Classname 合并链表
 * @Description TODO
 * @Date 2020/12/21 14:53
 * @Created by xjl
 */
public class 合并链表 {

    /**
     * @description TODO  链表的都是有序的
     * @param: head1
     * @param: head2
     * @date: 2020/12/21 14:58
     * @return: 复现代码.合并链表.ListNode
     * @author: xjl
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 != null) {
            return head2;
        }
        if (head1 != null && head2 == null) {
            return head1;
        }
        if (head1 == null && head2 == null) {
            return null;
        }

        ListNode dumpy = new ListNode(0);
        ListNode curr = dumpy;

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val >= curr2.val) {
                curr.next = curr2;
                curr2 = curr2.next;
            } else {
                curr.next = curr1;
                curr1 = curr1.next;
            }
            curr = curr.next;
        }
        while (curr1 != null) {
            curr.next = curr1;
            curr = curr.next;
            curr1 = curr.next;
        }
        while (curr2 != null) {
            curr.next = curr2;
            curr = curr.next;
            curr2 = curr.next;
        }
        return dumpy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
