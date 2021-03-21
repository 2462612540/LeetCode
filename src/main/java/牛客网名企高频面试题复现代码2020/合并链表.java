package 牛客网名企高频面试题复现代码2020;

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
    public ListNode merge2(ListNode head1, ListNode head2) {
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

    /**
     * @description TODO 采用的是归并的思想来实现的对链表的合并
      * @param: l1
     * @param: l2
     * @date: 2021/3/8 12:49
     * @return: 牛客网名企高频面试题复现代码2020.合并链表.ListNode
     * @author: xjl
    */
    public ListNode merge(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
