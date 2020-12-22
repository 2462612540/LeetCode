package 复现代码;

/**
 * @Classname 无序单链表的排序
 * @Description TODO
 * @Date 2020/12/22 17:34
 * @Created by xjl
 */
public class 无序单链表的排序 {

    /**
     * @description TODO  分割链表采用的快慢指针 第二是合并链表
     * @param: head
     * @date: 2020/12/22 17:36
     * @return: void
     * @author: xjl
     */
    public ListNode sortInList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;//一定要设置的head的下一个
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode head1 = sortInList(head);
        ListNode head2 = sortInList(second);
        ListNode ans = merge(head1, head2);
        return ans;
    }

    /**
     * @description TODO 合并链表
     * @param: head1
     * @param: head2
     * @date: 2020/12/22 18:13
     * @return: 复现代码.无序单链表的排序.ListNode
     * @author: xjl
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        ListNode res = new ListNode(0);
        ListNode dumpy = res;

        while (curr1 != null && curr2 != null) {
            if (curr1.val > curr2.val) {
                dumpy.next = curr2;
                curr2 = curr2.next;
            } else {
                dumpy.next = curr1;
                curr1 = curr1.next;
            }
            dumpy = dumpy.next;
        }
        if (curr1 != null) {
            dumpy.next = curr1;
        }
        if (curr2 != null) {
            dumpy.next = curr2;
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
