package 牛客网名企高频面试题复现代码;

/**
 * @Classname 判断链表时候有环
 * @Description TODO
 * @Date 2020/12/21 14:38
 * @Created by xjl
 */
public class 判断链表时候有环 {
    public boolean cycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
